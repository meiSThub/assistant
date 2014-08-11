package edu.zzuli.assistant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.zzuli.assistant.bean.Comment;
import edu.zzuli.assistant.dao.CommentDao;
import edu.zzuli.assistant.dao.NewsDao;
import edu.zzuli.assistant.dao.UserDao;
import edu.zzuli.assistant.dao.impl.CommentDaoImpl;
import edu.zzuli.assistant.dao.impl.NewsDaoImpl;
import edu.zzuli.assistant.dao.impl.UserDaoImpl;
import edu.zzuli.assistant.service.CommentService;
import edu.zzuli.assistant.until.HibernateUtil;

public class CommentServiceImpl implements CommentService {

	private NewsDao newsDao = new NewsDaoImpl();//
	private UserDao userDao = new UserDaoImpl();//
	private CommentDao commentDao=new CommentDaoImpl();//

	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = true;
		// 先用for循环 插入图片表

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			// 评论数+1
			newsDao.updateCommnetNum(comment.getNews().getId(), 1);
			// 插入评论
			commentDao.addComment(comment);
			// 被回复的用户表 收到的回复次数+1
			userDao.updateReplyNum(comment.getReplyId());
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		}finally{
			
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public boolean deleteComment(int commentId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;
		// 先用for循环 插入图片表

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			commentDao.deleteComment(commentId);
			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} 
		finally{
			
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public List<Comment> getNewsCommentList(int newsId, int pageNum,
			int PageSize) {
		// TODO Auto-generated method stub
		if (newsId > 0 && pageNum > 0 && PageSize > 0) {
			
			List<Comment> commentList = commentDao.selectNewsCommentList(newsId, pageNum, PageSize);
			HibernateUtil.closeSession();
			return commentList ;
		}
		return null;
	}

	@Override
	public List<Comment> getUserCommentList(String userId, int pageNum,
			int PageSize) {
		// TODO Auto-generated method stub
		if (userId != null && pageNum > 0 && PageSize > 0) {
			List<Comment> commentList = commentDao.selectUserCommentList(userId, pageNum, PageSize);
			for(Comment comment: commentList){
				Hibernate.initialize(comment.getNews());
			}
			HibernateUtil.closeSession();
			return commentList;
		}
		return null;
	}

	@Override
	public List<Comment> getReplyCommentList(String userId, int pageNum,
			int PageSize) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			if (userId != null && pageNum > 0 && PageSize > 0) {
				list = commentDao.selectReplyCommentList(userId, pageNum,
						PageSize);
				if(list!=null){
					for(Comment comment: list){
						
						Hibernate.initialize(comment.getNews());
					}
				}
				userDao.clearReplyNum(userId);
			}
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			list = null;
		}finally{
			
			HibernateUtil.closeSession();
		}
		return list;
	}


}

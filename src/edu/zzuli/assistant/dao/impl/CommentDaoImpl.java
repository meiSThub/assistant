/**
 * 
 */
package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.Comment;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.dao.CommentDao;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class CommentDaoImpl implements CommentDao {

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CommentDao#addComment(edu.zzuli.assistant.bean.Comment)
	 */
	@Override
	public boolean addComment(Comment comment) {
		// TODO Auto-generated method stub
		HibernateUtil.getCurrentSession().save(comment);
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CommentDao#deleteComment(int)
	 */
	@Override
	public boolean deleteComment(int commentId) {
		// TODO Auto-generated method stub
		String hql="delete from Comment comment where comment.id=?";
		Query query=HibernateUtil.getCurrentSession().createQuery(hql);
		query.setInteger(0, commentId);
		query.executeUpdate();
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CommentDao#selectNewsCommentList(int, int, int)
	 */
	@Override
	public List<Comment> selectNewsCommentList(int newsId, int pageNum,
			int PageSize) {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<Comment>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from Comment comment  where comment.news.id=? order by comment.postTime desc";
		Query query = session.createQuery(hql);
		query.setInteger(0, newsId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		commentList = query.list();
		return commentList;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CommentDao#selectUserCommentList(java.lang.String, int, int)
	 */
	@Override
	public List<Comment> selectUserCommentList(String userId, int pageNum,
			int PageSize) {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<Comment>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from Comment comment  where comment.authorId=?";
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		commentList = query.list();
		return commentList;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CommentDao#selectReplyCommentList(java.lang.String, int, int)
	 */
	@Override
	public List<Comment> selectReplyCommentList(String userId, int pageNum,
			int PageSize) {
		// TODO Auto-generated method stub
		List<Comment> commentList = new ArrayList<Comment>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from Comment comment  where comment.replyId=?";
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		commentList = query.list();
		return commentList;
	}


}

package edu.zzuli.assistant.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.NewsPic;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.CommentDao;
import edu.zzuli.assistant.dao.NewsDao;
import edu.zzuli.assistant.dao.NewsPicDao;
import edu.zzuli.assistant.dao.UserDao;
import edu.zzuli.assistant.dao.impl.CommentDaoImpl;
import edu.zzuli.assistant.dao.impl.NewsDaoImpl;
import edu.zzuli.assistant.dao.impl.NewsPicDaoImpl;
import edu.zzuli.assistant.dao.impl.UserDaoImpl;
import edu.zzuli.assistant.service.NewsService;
import edu.zzuli.assistant.until.HibernateUtil;

public class NewsServiceImpl implements NewsService {

	
	private NewsDao newsDao = new NewsDaoImpl();
	private NewsPicDao newsPicDao = new NewsPicDaoImpl() ;
	private CommentDao commentDao = new CommentDaoImpl() ;
	private UserDao userDao = new UserDaoImpl();
	
	public boolean PublishNews(News news) {
		Session session = null;
		Transaction tx = null;
		boolean result = false;
		// 先用for循环 插入图片表
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			newsDao.add(news);
			userDao.updateNewsNum(news.getUser().getId(), 1);
			//userDao.updateNewsNum(news.getUser().getId(), 1);
			// 以上操作全部成功 事物才能提交 否则回滚
			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} finally{
			HibernateUtil.closeSession();
		}

		return result;
	}

	@Override
	public boolean delteNews(String userId, int newsId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;
		// 先用for循环 插入图片表

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			newsDao.delteById(newsId);
			// 个人信息表历史发布条数 -1;
			userDao.updateNewsNum(userId, -1);

			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} finally{
			HibernateUtil.closeSession();
		}

		return result;
	}

	@Override
	public News getNews(int newsId) {
		// 查找news
		News news = newsDao.selectById(newsId);
		if(news!=null){
			//Hibernate.initialize(news.getNewsPic());
		}
		HibernateUtil.closeSession();
		return news;
	}

	@Override
	public List<News> getNewsList(int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		if (pageNum > 0 && PageSize > 0) {
			List<News> newsList = newsDao.selectNewsList(pageNum, PageSize);
			HibernateUtil.closeSession();
			return newsList;
		}
		return null;
	}

	@Override
	public List<News> getSelfNews(String userId, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		if (pageNum > 0 && PageSize > 0) {
			List<News> newsList = newsDao.selectSelfNews(userId, pageNum, PageSize);
			HibernateUtil.closeSession();
			return newsList ;
		}
		return null;
	}

	@Override
	public List<News> getFollowNews(String userId, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		if (pageNum > 0 && PageSize > 0) {
			
			List<News> newsList = newsDao.selectFollowNews(userId, pageNum, PageSize);
			HibernateUtil.closeSession();
			return newsList ;
		}
		return null;
	}

	@Override
	public List<News> getStatusNews(short status, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		
		List<News> newsList = newsDao.selectStatusNews(status, pageNum, PageSize);
		HibernateUtil.closeSession();
		return newsList ;
	}

	@Override
	public  List<News> getNewsByName(int name, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		if (pageNum > 0 && PageSize > 0) {
			
			List<News> newsList = newsDao.selectByName(name, pageNum, PageSize);
			HibernateUtil.closeSession();
			return newsList ;
		}
		return null;
	}
}

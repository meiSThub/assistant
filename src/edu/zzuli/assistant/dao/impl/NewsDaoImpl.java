/**
 * 
 */
package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.NewsDao;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 * @author name time
 * @version version-number
 * @param parameter
 *            -name description
 * @return description
 */

public class NewsDaoImpl implements NewsDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#add(edu.zzuli.assistant.bean.News)
	 */
	@Override
	public boolean add(News news) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		session.save(news);
		System.out.println(session.getIdentifier(news));
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#delteById(int)
	 */
	@Override
	public boolean delteById(int newsId) {
		// TODO Auto-generated method stub
		String hqlString = "delete from News news where news.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hqlString);
		query.setInteger(0, newsId);
		query.executeUpdate();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#selectById(int)
	 */
	@Override
	public News selectById(int newsId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		return (News) session.get(News.class, newsId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#updateCommnetNum(int, int)
	 */
	@Override
	public boolean updateCommnetNum(int newsId, int num) {
		// TODO Auto-generated method stub
		int newsNum = this.selectById(newsId).getCommentNum() + num;
		String hql = "update News news set news.commentNum=? where news.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, newsNum);
		query.setInteger(1, newsId);
		query.executeUpdate();
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#selectNewsList(int, int)
	 */
	@Override
	public List<News> selectNewsList(int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<News> newsList = new ArrayList<News>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from News news order by news.postTime desc ";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		newsList = query.list();
		return newsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#selectSelfNews(int, int, int)
	 */
	@Override
	public List<News> selectSelfNews(String userId, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<News> newsList = new ArrayList<News>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from News news  where news.user.id =? order by news.postTime desc";
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		newsList = query.list();
		return newsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.NewsDao#selectFollowNews(int, int, int)
	 */
	@Override
	public List<News> selectFollowNews(String userId, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM news WHERE author_id IN (SELECT start_id FROM follow WHERE fans_id= ?) order by news.post_time desc";
		SQLQuery query=HibernateUtil.getCurrentSession().createSQLQuery(sql);
		query.setString(0, userId);
		query.addEntity(News.class);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		List<News> newsList=new ArrayList<News>();
		newsList=query.list();
		return newsList;
	}

	@Override
	public List<News> selectStatusNews(short status, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM News ,USER WHERE user.id=news.author_id  and user.status=? order by news.post_time desc";
		SQLQuery query=HibernateUtil.getCurrentSession().createSQLQuery(sql);
		query.setShort(0, status);
		query.addEntity(News.class);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		List<News> newsList=new ArrayList<News>();
		newsList=query.list();
		return newsList;
	}

	@Override
	public List<News> selectByName(int name,int pageNum, int PageSize) {
		
		List<News> newsList = new ArrayList<News>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from News as news  where news.name like ? order by news.postTime desc";
		Query query = session.createQuery(hql);
		query .setString(0, "%" + name + "%");
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		newsList = query.list();
		return newsList;
	}

}

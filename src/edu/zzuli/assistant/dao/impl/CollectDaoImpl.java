/**
 * 
 */
package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.dao.CollectDao;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class CollectDaoImpl implements CollectDao {

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CollectDao#add(edu.zzuli.assistant.bean.Collect)
	 */
	@Override
	public boolean add(Collect collect) {
		// TODO Auto-generated method stub
		String hql="from Collect collect where collect.news.id=? and collect.userId=?";
		Query query=HibernateUtil.getCurrentSession().createQuery(hql);
		query.setInteger(0, collect.getNews().getId());
		query.setString(1, collect.getUserId());
		List<Collect> list=new ArrayList<Collect>();
		list=query.list();
		if(list.size()==0){
			HibernateUtil.getCurrentSession().save(collect);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CollectDao#deleteById(int)
	 */
	@Override
	public boolean deleteById(String userId, int newsId) {
		// TODO Auto-generated method stub
		String hql="delete from Collect collect where collect.userId=? and collect.news.id=?";
		Query query=HibernateUtil.getCurrentSession().createQuery(hql);
		query.setString(0, userId);
		query.setInteger(1, newsId);
		query.executeUpdate();
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.CollectDao#selectList(int, int, int)
	 */
	@Override
	public List<News> selectList(String userId, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<News> newsList = new ArrayList<News>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "select collect.news from Collect collect  where collect.userId=?";
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		newsList = query.list();
		return newsList;
	}

}

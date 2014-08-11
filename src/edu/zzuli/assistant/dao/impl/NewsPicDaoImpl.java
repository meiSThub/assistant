/**
 * 
 */
package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.NewsPic;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.NewsPicDao;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class NewsPicDaoImpl implements NewsPicDao {

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NewsPicDao#add(edu.zzuli.assistant.bean.NewsPic)
	 */
	@Override
	public boolean add(NewsPic newsPic) {
		// TODO Auto-generated method stub
		HibernateUtil.getCurrentSession().save(newsPic);
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NewsPicDao#delteById(int)
	 */
	@Override
	public boolean delteById(String newsPicUrl) {
		// TODO Auto-generated method stub
		String hql="delete from NewsPic newsPic where newsPic.picUrl=?";
		Session session=HibernateUtil.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setString(0, newsPicUrl);
		query.executeUpdate();
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NewsPicDao#selectList(int)
	 */
	@Override
	public List<NewsPic> selectNewsPic(int newsId) {
		// TODO Auto-generated method stub
		List<NewsPic> newsPicList = new ArrayList<NewsPic>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from NewsPic newsPic where newsPic.newsId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, newsId);
		newsPicList = query.list();
		return newsPicList;
	}

}

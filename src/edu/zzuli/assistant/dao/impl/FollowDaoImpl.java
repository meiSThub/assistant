/**
 * 
 */
package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.FollowDao;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class FollowDaoImpl implements FollowDao {

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.FollowDao#insert(edu.zzuli.assistant.bean.Follow)
	 */
	@Override
	public boolean add(Follow follw) {
		// TODO Auto-generated method stub
		HibernateUtil.getCurrentSession().save(follw);
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.FollowDao#deleteById(int)
	 */
	@Override
	public boolean deleteById(String fansId, String startId) {
		// TODO Auto-generated method stub
		String hql = "delete from Follow follow where follow.fansId=? and follow.startId=?";
		Query query = HibernateUtil.getCurrentSession().createQuery(hql);
		query.setString(0, fansId);
		query.setString(1, startId);
		query.executeUpdate();
		return false;
	}
	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.FollowDao#selectFunsList(int)
	 */
	@Override
	public List<Follow> selectStartList(String userId) {
		// TODO Auto-generated method stub
		List<Follow> followList=new ArrayList<Follow>();
		String hqlString="from Follow follow where follow.fansId=?";
		Query query=HibernateUtil.getCurrentSession().createQuery(hqlString);
		query.setString(0, userId);
		followList=query.list();
		return followList;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.FollowDao#selectFunsUserList(int)
	 */
	@Override
	public List<User> selectFansUserList(String userId,int pageNum,int PageSize) {
		// TODO Auto-generated method stub
		List<User> funsList=new ArrayList<User>();
		String sqlString="SELECT * FROM  user  WHERE id IN (SELECT fans_id FROM follow WHERE start_id=?)";
		SQLQuery query=HibernateUtil.getCurrentSession().createSQLQuery(sqlString);
		query.addEntity(User.class);
		query.setString(0, userId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		funsList=query.list();
		return funsList;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.FollowDao#getFollowUserList(int)
	 */
	@Override
	public List<User> selectStartUserList(String userId,int pageNum,int PageSize) {
		// TODO Auto-generated method stub
		List<User> startList=new ArrayList<User>();
		String sqlString="SELECT * FROM  user  WHERE id IN (SELECT start_id FROM follow WHERE fans_id=?)";
		SQLQuery query=HibernateUtil.getCurrentSession().createSQLQuery(sqlString);
		query.addEntity(User.class);
		query.setString(0, userId);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		startList=query.list();
		return startList;
	}
}

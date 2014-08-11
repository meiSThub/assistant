package edu.zzuli.assistant.service.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.FollowDao;
import edu.zzuli.assistant.dao.UserDao;
import edu.zzuli.assistant.dao.impl.FollowDaoImpl;
import edu.zzuli.assistant.dao.impl.UserDaoImpl;
import edu.zzuli.assistant.service.FollowService;
import edu.zzuli.assistant.until.HibernateUtil;

public class FollowServiceImpl implements FollowService{
	
	private FollowDao followDao = new FollowDaoImpl();
	private UserDao userdao = new UserDaoImpl();
	@Override
	public boolean add(Follow follw) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			followDao.add(follw);
			userdao.updateFollowNum(follw.getFansId(), 1);
			userdao.updateFansNum(follw.getStartId(), 1);
			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} finally {
			HibernateUtil.closeSession();
		}

		return result;
	}

	@Override
	public boolean deleteById(String fansId, String startId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			followDao.deleteById(fansId, startId);
			userdao.updateFollowNum(fansId, -1);
			userdao.updateFansNum(startId, -1);
			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} finally {

			HibernateUtil.closeSession();
		}

		return result;
	}


	@Override
	public List<Follow> getStartList(String userId) {
		// TODO Auto-generated method stub
		 HibernateUtil.closeSession();
		 List<Follow> followList =  followDao.selectStartList(userId);
		 HibernateUtil.closeSession();
		 return followList;
	}

	@Override
	public List<User> getFansUserList(String userId,int pageNum,int PageSize) {
		// TODO Auto-generated method stub
		List<User> userList = followDao.selectFansUserList(userId, pageNum, PageSize);
		HibernateUtil.closeSession();
		return userList;
	}

	@Override
	public List<User> getStartUserList(String userId,int pageNum,int PageSize) {
		// TODO Auto-generated method stub
		List<User> userList =  followDao.selectStartUserList(userId, pageNum, PageSize);
		HibernateUtil.closeSession();
		return userList;
	}

}

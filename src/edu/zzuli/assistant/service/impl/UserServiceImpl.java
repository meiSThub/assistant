package edu.zzuli.assistant.service.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.UserDao;
import edu.zzuli.assistant.dao.impl.UserDaoImpl;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 * @Description: UserService的业务层
 * @author MR.Wang
 * @date 2014-7-23 下午11:43:38
 * @version V1.0
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();// 别忘记初始化

	@Override
	public boolean addUser(User user) {
		// 先要做user 的合法性验证
		// session 放在这一层
		Session session = null;
		Transaction tx = null;
		boolean result = true;
		if (user.getId() != null && user.getName() != null
				&& user.getPassword() != null)
			try {
				session = HibernateUtil.getCurrentSession();
				tx = session.beginTransaction();
				userDao.add(user);
				tx.commit();
			} catch (Exception exception) {
				result = false;
			}finally{
				
				HibernateUtil.closeSession();
			}

		return result;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean login(User user) {
		boolean result = userDao.exists(user);
		HibernateUtil.closeSession();
		return result;
	}

	@Override
	public User getUserBaseInfo(String userId) {
		User  user=  userDao.selectById(userId);
		HibernateUtil.closeSession();
		return user;
	}

	@Override
	public boolean modifyHeadImg(String userId, String headUrL) {
		// TODO Auto-generated method stub
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			userDao.updateHead(userId, headUrL);
			tx.commit();
			result = true;
		} catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public boolean modifyIntro(String userId, String intro) {
		// TODO Auto-generated method stub
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		if (userId != null && intro != null) {
			try {
				session = HibernateUtil.getCurrentSession();
				tx = session.beginTransaction();
				userDao.updateIntro(userId, intro);
				tx.commit();
				result = true;
			} catch (HibernateException he) {
				tx.rollback();
				he.printStackTrace();
			} 
			finally{
				HibernateUtil.closeSession();
			}
		}
		return result;
	}

	public boolean modifyPassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			userDao.updatePassword(user.getId(), newPassword);
			tx.commit();
			result = true;
			session .clear();
		} catch (HibernateException he) {
			tx.rollback();
			he.printStackTrace();
		} 
		finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public List<User> getPublicList(int pageNum, int PageSize) {
		
		if (pageNum > 0 && PageSize > 0) {
			List<User> userList = userDao.selectPublicList(pageNum, PageSize);
			HibernateUtil.closeSession();
			return userList;
		}
		return null;
	}


	@Override
	public List<User> getTeacherList(int pageNum, int PageSize) {
		
		if (pageNum > 0 && PageSize > 0) {
			List<User> userList = userDao.selectTeacherList(pageNum, PageSize);
			HibernateUtil.closeSession();
			return userList;
		}			
		return null;
	}

	@Override
	public boolean updateEmail(User user) {
		// TODO Auto-generated method stub
		// 先验证密码 是否正确
		
		if(login(user)){
			
			boolean result = false;
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtil.getCurrentSession();
				tx = session.beginTransaction();
				userDao.updateEmail(user.getId(), user.getEmail());
				tx.commit();
				result = true;
				session .clear();
			} catch (HibernateException he) {
				tx.rollback();
				he.printStackTrace();
			} 
			finally{
				HibernateUtil.closeSession();
			}
			return result;
		}
		return false;
	}

	@Override
	public boolean hasThisEmail(String email) {
		// TODO Auto-generated method stub
		boolean restult = userDao.hasThisEmail(email);
		HibernateUtil.closeSession();
		return  restult;
	}

	@Override
	public List<User> getUserByName(String name, short status,int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		
		if (pageNum > 0 && PageSize > 0) {
			List<User> userList = userDao.selectByName(name, status,pageNum, PageSize);
			HibernateUtil.closeSession();
			return userList;
		}
		return null;
	}
}

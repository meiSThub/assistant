package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.UserDao;
import edu.zzuli.assistant.until.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		session = HibernateUtil.getCurrentSession();
		session.save(user);
		return false;
	}

	@Override
	public boolean exists(User user) {
		
		User tempUser = selectById(user.getId());
		if(tempUser!=null){
			return tempUser.getPassword().equals(user.getPassword());
		}
		return false;
	}

	@Override
	public User selectById(String userId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		return (User) session.get(User.class, userId);
	}

	@Override
	public boolean updateNewsNum(String userId, int num) {

		User user = this.selectById(userId);
		int newsNum = user.getNewsNum() + num;
		String hql = "update User user set user.newsNum=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, newsNum);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	@Override
	public boolean updateReplyNum(String userId) {
		// TODO Auto-generated method stub
		User user = this.selectById(userId);
		int replyNum = user.getNewReply() + 1;
		String hql = "update User user set user.newReply=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, replyNum);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	@Override
	public boolean clearReplyNum(String userId) {
		// TODO Auto-generated method stub
		String hql = "update User user set user.newReply=0 where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.executeUpdate();
		return false;
	}

	@Override
	public boolean updateHead(String userId, String headUrL) {
		// TODO Auto-generated method stub
		String hql = "update User user set user.headUrl=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, headUrL);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	@Override
	public boolean updateIntro(String userId, String intro) {
		// TODO Auto-generated method stub
		String hql = "update User user set user.intro=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, intro);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	@Override
	public boolean updatePassword(String userId, String newPassword) {
		// TODO Auto-generated method stub
		String hql = "update User user set user.password=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, newPassword);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	@Override
	public List<User> selectPublicList(int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<User> publicList = new ArrayList<User>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from User user where user.status=2";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)*PageSize);
		query.setMaxResults(PageSize);
		publicList = query.list();
		return publicList;
	}

	@Override
	public List<User> selectTeacherList(int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<User> teacherList = new ArrayList<User>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from User user where user.status=1";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)*PageSize);
		query.setMaxResults(PageSize);
		teacherList = query.list();
		return teacherList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.UserDao#updateFollowNum(java.lang.String,
	 * int)
	 */
	@Override
	public boolean updateFollowNum(String userId, int followNum) {
		// TODO Auto-generated method stub
		User user = this.selectById(userId);
		int newFollowNum = user.getFollowNum() + followNum;
		String hql = "update User user set user.followNum=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, newFollowNum);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.UserDao#clearFollowNum(java.lang.String)
	 */
	@Override
	public boolean clearNewFollowNum(String userId) {
		// TODO Auto-generated method stub
		String hql = "update User user set user.followNum=0 where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.executeUpdate();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.UserDao#updateFollowmeNum(java.lang.String,
	 * int)
	 */
	@Override
	public boolean updateFansNum(String userId, int followmeNum) {
		// TODO Auto-generated method stub
		int newFollowmeNum = this.selectById(userId).getFansNum()
				+ followmeNum;
		String hql = "update User user set user.fansNum=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, newFollowmeNum);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.UserDao#clearFollowmeNum(java.lang.String)
	 */
	@Override
	public boolean clearNewFansNum(String userId) {
		// TODO Auto-generated method stub
/*		String hql = "update User user set user.followmeNum=0 where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, userId);
		query.executeUpdate();*/
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.zzuli.assistant.dao.UserDao#updateEmail(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean updateEmail(String userId, String newEmail) {
		// TODO Auto-generated method stub
		
		String hql = "update User user set user.email=? where user.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, newEmail);
		query.setString(1, userId);
		query.executeUpdate();
		return false;
	}
	
	@Override
	public boolean hasThisEmail(String email) {
		// TODO Auto-generated method stub
		String sql="select * from user where eamil=?";
		Session session=HibernateUtil.getCurrentSession();
		SQLQuery query=session.createSQLQuery(sql);
		query.setString(0, email);
		query.addEntity(User.class);
		List<User> emailList=new ArrayList<User>();
		emailList=query.list();
		if(emailList.size()!=0){
			return true;
		}
		return false;
	}

	@Override
	public List<User> selectByName(String name, short status,int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from User as user where user.name like ? and user.status = ?";
		Query query = session.createQuery(hql);
		query .setString(0, "%" + name + "%");
		query .setShort(1, status);
		query.setFirstResult((pageNum-1)*PageSize);
		query.setMaxResults(PageSize);
		userList = query.list();
		return userList;
	}

}

/**
 * 
 */
package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.dao.NoticeDao;
import edu.zzuli.assistant.until.HibernateUtil;

/**
 *@author name time 
 *@version version-number
 *@param parameter-name description
 *@return description
 */

public class NoticeDaoImpl implements NoticeDao {

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NoticeDao#add(edu.zzuli.assistant.bean.Notice)
	 */
	@Override
	public boolean add(Notice notice) {
		// TODO Auto-generated method stub
		HibernateUtil.getCurrentSession().save(notice);
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NoticeDao#selectById(int)
	 */
	@Override
	public Notice selectById(int noticeId) {
		// TODO Auto-generated method stub		
		return (Notice) HibernateUtil.getCurrentSession().get(Notice.class, noticeId);
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NoticeDao#deleteById(int)
	 */
	@Override
	public boolean deleteById(int noticeId) {
		String hql="delete from Notice notice where notice.id=?";
		Session session = HibernateUtil.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setInteger(0, noticeId);
		query.executeUpdate();
		System.out.println("333333333333333333333");
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.zzuli.assistant.dao.NoticeDao#selectNotic(int, int)
	 */
	@Override
	public List<Notice> selectNotic(int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		List<Notice> noticeList = new ArrayList<Notice>();
		Session session = HibernateUtil.getCurrentSession();
		String hql = "from Notice notice order by notice.postTime desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum-1)* PageSize);
		query.setMaxResults(PageSize);
		noticeList = query.list();
		return noticeList;
	}

}

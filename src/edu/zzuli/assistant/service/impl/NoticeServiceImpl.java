package edu.zzuli.assistant.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.zzuli.assistant.bean.Admin;
import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.bean.NoticePic;
import edu.zzuli.assistant.dao.NewsPicDao;
import edu.zzuli.assistant.dao.NoticeDao;
import edu.zzuli.assistant.dao.impl.NewsPicDaoImpl;
import edu.zzuli.assistant.dao.impl.NoticeDaoImpl;
import edu.zzuli.assistant.service.NoticeService;
import edu.zzuli.assistant.until.HibernateUtil;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao = new NoticeDaoImpl();
	//private NewsPicDao noticePicDao = new No();

	@Override
	public boolean publishNotice(Notice notice) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;
		if (notice.getAdminId() != null
				&& notice.getAuthorName() != null
				&& notice.getTitle() != null
				&& notice.getContent() != null)
			try {
				session = HibernateUtil.getCurrentSession();
				tx = session.beginTransaction();
				noticeDao.add(notice);
				result = true;
				tx.commit();
			} catch (Exception e) {
				result = false;

			} finally{
				HibernateUtil.closeSession();
			}
		return result;
	}

	@Override
	public Notice selectById(int noticeId) {
		// TODO Auto-generated method stub
		Notice notice  = noticeDao.selectById(noticeId);
/*		if(notice!=null){
			Hibernate.initialize(notice.getNoticePic());
		}*/
		HibernateUtil.closeSession();
		return notice;
	}

	@Override
	public boolean deleteById(int collectId) {
		// TODO Auto-generated method stub
		boolean result=false;
		Session session = null;
		Transaction tx = null;
		if(collectId>0){
			try{
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			noticeDao.deleteById(collectId);
			System.out.println("+++++++++++++++++++++"+collectId);
			result=true;
			}
			catch(HibernateException e){
				tx.rollback();
			}
			 finally{
					HibernateUtil.closeSession();
			}
		}
		
		return result;
	}

	@Override
	public List<Notice> getNoticList(int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		if(pageNum<0||PageSize<0){
			return null;
		}
		List<Notice> noticeList = noticeDao.selectNotic(pageNum, PageSize);
		HibernateUtil.closeSession();
		return noticeList;
	}

}

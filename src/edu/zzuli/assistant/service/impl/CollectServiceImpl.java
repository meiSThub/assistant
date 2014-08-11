package edu.zzuli.assistant.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.dao.CollectDao;
import edu.zzuli.assistant.dao.impl.CollectDaoImpl;
import edu.zzuli.assistant.service.CollectService;
import edu.zzuli.assistant.until.HibernateUtil;

public class CollectServiceImpl implements CollectService {

	private CollectDao collectDao = new CollectDaoImpl();

	@Override
	public boolean addCollect(Collect collect) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			collectDao.add(collect);
			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} 
		return result;
	}

	@Override
	public boolean deleteCollect(String userId, int newsId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		boolean result = false;

		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			collectDao.deleteById(userId, newsId);
			tx.commit();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			result = false;
		} 
		return result;
	}

	@Override
	public List<News> getCollectList(String userId, int pageNum, int PageSize) {
		// TODO Auto-generated method stub
		if (userId != null && pageNum > 0 && PageSize > 0) {
			return collectDao.selectList(userId, pageNum, PageSize);
		}
		return null;
	}
}

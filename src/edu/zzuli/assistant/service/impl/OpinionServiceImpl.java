package edu.zzuli.assistant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.zzuli.assistant.bean.Opinion;
import edu.zzuli.assistant.dao.OpinionDao;
import edu.zzuli.assistant.dao.impl.OpinionDaoImpl;
import edu.zzuli.assistant.service.OpinionService;
import edu.zzuli.assistant.until.HibernateUtil;

public class OpinionServiceImpl implements OpinionService {

	private OpinionDao opinionDao=new OpinionDaoImpl();
	@Override
	public boolean add(Opinion op) {
		boolean result=false;
		Session session=null;
		Transaction tx=null;
		try{
			session=HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			opinionDao.add(op);
			tx.commit();
			result=true;
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			result = false;
		}finally{
			HibernateUtil.closeSession();
		}
		return result;
	}

	@Override
	public List<Opinion> list(int pageNum, int PageSize) {
		List<Opinion> opList=null;
		Session session=null;
		Transaction tx=null;
		try{
			session =HibernateUtil.getCurrentSession();
			tx=session.beginTransaction();
			opList=opinionDao.list(pageNum, PageSize);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}finally{
			HibernateUtil.closeSession();
		}
		return opList;
	}

}

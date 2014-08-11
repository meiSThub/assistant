package edu.zzuli.assistant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.Opinion;
import edu.zzuli.assistant.dao.OpinionDao;
import edu.zzuli.assistant.until.HibernateUtil;

public class OpinionDaoImpl implements OpinionDao {

	@Override
	public boolean add(Opinion op) {
		HibernateUtil.getCurrentSession().save(op);
		return false;
	}

	@Override
	public List<Opinion> list(int pageNum,int PageSize) {
		List<Opinion> opList=new ArrayList<Opinion>();
		Session session=HibernateUtil.getCurrentSession();
		String hql="from Opinion opinion order by post_time desc";
		Query query=session.createQuery(hql);
		query.setFirstResult((pageNum-1)*PageSize);
		query.setMaxResults(PageSize);
		opList=query.list();
		return opList;
	}

}

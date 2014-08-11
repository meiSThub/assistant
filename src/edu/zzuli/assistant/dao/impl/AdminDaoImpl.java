package edu.zzuli.assistant.dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.zzuli.assistant.bean.Admin;
import edu.zzuli.assistant.dao.AdminDao;
import edu.zzuli.assistant.until.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin exists(Admin admin) {
		
		Session session=HibernateUtil.getCurrentSession();
		String hql = "from Admin admin where admin.email=? and admin.password=?";
		Query query=session.createQuery(hql);
		query.setString(0, admin.getEmail());
		query.setString(1, admin.getPassword());
		List<Admin> admins=new ArrayList<Admin>();
		admins=query.list();
		Admin ad=null;
		if(admins.size()!=0){
			for(Admin a:admins){
				ad=a;
			}
		}
		return ad;
	}
	

}

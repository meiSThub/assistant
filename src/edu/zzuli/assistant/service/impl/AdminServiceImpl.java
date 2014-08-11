package edu.zzuli.assistant.service.impl;

import edu.zzuli.assistant.bean.Admin;
import edu.zzuli.assistant.dao.AdminDao;
import edu.zzuli.assistant.dao.impl.AdminDaoImpl;
import edu.zzuli.assistant.service.AdminService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.until.HibernateUtil;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao=new AdminDaoImpl();
	
	
	@Override
	public Admin login(Admin admin) {
		Admin result=adminDao.exists(admin);
		if(result!=null){
			HibernateUtil.closeSession();
		}
		return result;
	}
	
}

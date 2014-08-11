package edu.zzuli.assistant.dao;

import edu.zzuli.assistant.bean.Admin;

public interface AdminDao {
	
	/**
	 * @Description 是否存在该用户
	 * @param user 用户对象(只需要用户名和密码)
	 * @return Admin 
	 */
	public  abstract Admin exists(Admin admin);
	
}

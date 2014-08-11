package edu.zzuli.assistant.service;

import edu.zzuli.assistant.bean.Admin;

public interface AdminService {
	
	/**
	 * 管理员登陆
	 * @param admin 管理员对象
	 * @return
	 */
	public abstract Admin login(Admin admin);
}

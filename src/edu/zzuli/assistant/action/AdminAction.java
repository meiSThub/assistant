package edu.zzuli.assistant.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.zzuli.assistant.bean.Admin;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.AdminService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.AdminServiceImpl;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class AdminAction extends ActionSupport implements SessionAware {

	private AdminService adminService = new AdminServiceImpl();

	private Map<String, Object> session;

	private Admin admin = null;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		if (admin == null) {
			this.admin = new Admin();
		}
		return admin;
	}

	// 重定向到首页
	private void redirectIndex() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String contextPath = ((HttpServletRequest) request).getContextPath();
		try {
			response.sendRedirect(contextPath + "/index.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 发送ajax 返回值
	public void sendMsg(String content) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 管理员登陆
	 * @return
	 */
	public String login() {

		this.getModel();
		String status = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		String refer = request.getHeader("referer");
		// 用refer 拦截
		if (refer == null || refer.indexOf("/assistant/") < 0) {
			redirectIndex();
			status = "fail";
		}

		if (admin.getEmail() == null || admin.getPassword() == null) {
			status = "fail";
		} else {
			Admin result = adminService.login(admin);
			if (result != null) {
				session.put("id", result.getId());
				session.put("name", result.getName());
				status = "success";
			}
		}
		return status;
	}
	
	public String adPublic(){
		if(session.get("id")!=null){
			return "success";
		}
		return "fail";
	}
}

package edu.zzuli.assistant.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zzuli.assistant.api.action.NoticeAction;
import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.FollowService;
import edu.zzuli.assistant.service.NewsService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.FollowServiceImpl;
import edu.zzuli.assistant.service.impl.NewsServiceImpl;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven,SessionAware{
	
	private UserService userService=new UserServiceImpl();
	private FollowService followService = new FollowServiceImpl();
	private NewsService newsService=new NewsServiceImpl();
	private Map<String, Object> session;
	private User user;

	private List<User> userList;// 用户集合
	private List<Follow> followList;// 已关注的人集合
	private int page =1;//当前页数 默认第一页
	private List <News> newsList;
	
	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<Follow> getFollowList() {
		return followList;
	}

	public void setFollowList(List<Follow> followList) {
		this.followList = followList;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(user==null){
			this.user= new User();
		}
		return user;
	} 
	
	//发送ajax 返回值
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
    
    // 登录验证
    public void login(){
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpServletResponse response = ServletActionContext.getResponse();
    	String refer= request.getHeader("referer");
    	// 用refer 拦截
    	if(refer==null || refer.indexOf("/assistant/")<0){
    		redirectIndex();
    		return;
    	}
    	// 登陆验证
    	if(user.getId()==null || user.getPassword()==null){
    		sendMsg("fail");
    	}
    	else{
    		//判断用户是否存在
    		boolean result=userService.login(user); 
    		if (result) {
    			user = userService.getUserBaseInfo(user.getId());
    			session.put("userId", user.getId());
    			session.put("userName", user.getName());
    			session.put("status", user.getStatus());
    			session.put("headUrl", user.getHeadUrl());
    			sendMsg("success");
    		} else {
    			sendMsg("fail");
    		}
    	}
    }
    
    //退出   user_logout.action
    public String logout(){
    	session.clear();
		return LOGIN;
    }
    // 公众号列表  user_publicnum.action
	public String publicnum(){
		
		userList = userService.getPublicList(page, 10);
		//找出已关注的人
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			followList = followService.getStartList(userId);
		}
		return SUCCESS;
	}
	//教师列表  user_teacher.action
	public String teacher(){
		
		userList = userService.getTeacherList(page, 10);
		//找出已关注的人
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			followList = followService.getStartList(userId);
		}
		return SUCCESS;
	}
	
	//个人账户 user_account.action
	public String account(){
		
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			user = userService.getUserBaseInfo(userId);
			return "account";
		}
		return LOGIN;                
	}
	// 更新简介 modifyIntro.action
	public void modifyIntro(){
		if(session.get("userId")!=null){
			
			if(user.getIntro()==null || user.getIntro().length()>15){
				sendMsg("fail");
				return;
			}
			String userId= session.get("userId").toString();
			boolean result = userService.modifyIntro(userId, user.getIntro()); 
			if(result){
				sendMsg("success");
			}
			else{
				sendMsg("fail");
			}
			return;
		}
		redirectIndex();
		return;
		
	}
	
	// 更新邮箱 modifyIntro.action
	public void modifyEmail(){
		if(session.get("userId")!=null){
			
			if(user.getEmail()==null || 
					user.getEmail().length()<6 ||
					user.getEmail().length()>20 || 
					user.getPassword()==null || 
					user.getPassword().length()<6||
					user.getPassword().length()>12){
				sendMsg("fail");
				return;
			}
			user.setId(session.get("userId").toString());
			boolean result = userService.updateEmail(user); 
			if(result){
				sendMsg("success");
			}
			else{
				sendMsg("fail");
			}
			return;
		}
		redirectIndex();
		return;
	}
	// 更新密码 modifyIntro.action
	public void modifyPassword(){
		if(session.get("userId")!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			user.setId(session.get("userId").toString());
			String newPassword = request.getParameter("newPassword");
			
			if(newPassword ==null || newPassword.length()<6|| newPassword.length()>12){
				sendMsg("fail");
				return;
			}
    		boolean result=userService.login(user); 
    		if (result) {
    			result = userService.modifyPassword(user, newPassword);
    			if(result){
    				sendMsg("success");
    			}
    			else{
    				sendMsg("fail");
    			}
    		} else {
    			sendMsg("password_error");
    		}
    		return;
		}
		redirectIndex();
		return;
	}
	
	// 重定向到首页
	private void redirectIndex(){
    	HttpServletRequest request = ServletActionContext.getRequest();
    	HttpServletResponse response = ServletActionContext.getResponse();
		String contextPath=((HttpServletRequest)request).getContextPath();
		try {
			response.sendRedirect(contextPath+"/index.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取辅导员被关注人的基本信息
	public String startDetail(){
			
			if (user.getId()==null) {
				return "user_teacher";			
			}else {
			this.user = userService.getUserBaseInfo(user.getId());
			
			newsList=newsService.getSelfNews(user.getId(), page, 8);
			
			if(session.get("userId")!=null){
				
				String userId= session.get("userId").toString();
				followList=	followService.getStartList(userId);
			}
			
			
				return "start_detail";
			}
	}
	//获取公共号被关注人的基本信息
	public String publicStartDetail(){
		
		if (user.getId()==null) {
			return "user_public";			
		}else {
		this.user = userService.getUserBaseInfo(user.getId());
//		System.out.println(user.getId());
		newsList=newsService.getSelfNews(user.getId(), page, 8);
		
		if(session.get("userId")!=null){
			
			String userId= session.get("userId").toString();
			followList=	followService.getStartList(userId);
		}
		
		
			return "start_publicDetail";
		}
}
//获取关注辅导员的人的基本信息
	public String fansDetail(){
//		System.out.println(user.getId()+".......................");
		if (user.getId()==null) {
			return "user_fans";
			
		}else {
			this.user=userService.getUserBaseInfo(user.getId());
			newsList=newsService.getSelfNews(user.getId(), page, 8);
			String userId= session.get("userId").toString();
			followList=	followService.getStartList( userId);
			return "fans_detail";
		}
		
	}

	//搜索教师
	public String SeekTeacher(){
		
		userList =userService.getUserByName(user.getName(),(short)1,page, 10);

			return SUCCESS;
		
	}
	//搜索公众号
	public String SeekPublic(){
		
		userList =userService.getUserByName(user.getName(),(short)2,page, 10);
			return SUCCESS;
		
	}
<<<<<<< HEAD
	/**
	 * 开通公众号，即添加用户
	 * @return
	 */
	public String add(){
		user.setStatus(User.STATUS_PUBLIC);
		if(session.get("id")!=null){
			boolean result=userService.addUser(user);
			if(result){
				return "manage";//添加成功,跳到发布管理
			}
			return "adduser";//添加失败，继续添加
		}else{
			return "admin_login";//管理员没登陆，
		}
	}
=======
>>>>>>> 320172c113a8201b301c214c195902f7b960c821
}


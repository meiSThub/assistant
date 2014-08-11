package edu.zzuli.assistant.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.dao.FollowDao;
import edu.zzuli.assistant.dao.impl.FollowDaoImpl;
import edu.zzuli.assistant.service.FollowService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.FollowServiceImpl;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class FollowAction extends ActionSupport implements SessionAware,ModelDriven{
	
	
	private FollowService followService = new FollowServiceImpl();
	private UserService userService=new UserServiceImpl();
	private List<User> userList;
	private int page = 1;
	private Map<String, Object> session;
	private Follow follw;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Follow getFollw() {
		return follw;
	}

	public void setFollw(Follow follw) {
		this.follw = follw;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	

	//粉丝列表   follow_fans.action
	public String fans(){
		
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			userList = followService.getFansUserList(userId,page,8);
			user = userService.getUserBaseInfo(userId);
			return "fans_list";
		}
		return null;
	}
	
	// 我关注的人   follow_start.action;  
	public String start(){
		
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			userList = followService.getStartUserList(userId,page,8);
			user = userService.getUserBaseInfo(userId);
			return "start_list";
		}
		return null;
	}
//辅导员取消关注follow_cancel.action
	public String cancel(){
	
		if (session.get("userId")!=null) {
			 String userId = session.get("userId").toString();
			 System.out.println(userId);
			 if (userId==null||follw.getStartId()==null) {
			    	
				return "teacherStart_list";
				
			}else {
				boolean follboo=followService.deleteById(follw.getFansId(), follw.getStartId());
				
				if (follboo) {				
					return  "teacherStart_list";
					
			}else {
				return "teacherStart_list";
			}
			}
}	
	return LOGIN;
}
	
//辅导员增加关注follow_add.action
	public String add(){
		
		if (session.get("userId")!=null) {
			 String userId = session.get("userId").toString();
	
			 if (userId==null||follw.getStartId()==null) {
			
				 return "user_teacher";				 				
			}else {
				follw.setFansId(userId);
			    boolean follboo=followService.add(follw);
				if (follboo) {
				
					return "user_teacher";
					
				}else {
					return "user_teacher";
				}
			}
			
		}	
		return LOGIN;
	}
	//公共号增加关注follow_publicAdd.action
		public String publicAdd(){

			if (session.get("userId")!=null) {
				 String userId = session.get("userId").toString();
		
				 if (userId==null||follw.getStartId()==null) {
				
					 return "user_public";				 				
				}else {
					follw.setFansId(userId);
				    boolean follboo=followService.add(follw);
					if (follboo) {
						return "user_public";
						
					}else {
						return "user_public";
					}
				}
			}	
			return LOGIN;
		}
	
@Override
public Object getModel() {
	// TODO Auto-generated method stub
	if (follw!=null) {
		this.follw=new Follow();
		
	}
	return follw;
}
}

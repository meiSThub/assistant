package edu.zzuli.assistant.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.CollectService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.CollectServiceImpl;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class CollectAction  extends ActionSupport implements SessionAware ,ModelDriven{
	
	private CollectService collectService=new CollectServiceImpl();
	private UserService userService=new UserServiceImpl();
	private Map<String, Object> session;
	private List<News> newsList;//收藏集合  
	private int page=1;//当前页数默认第一页
	private Collect collect;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public List<News> getNewsList() {
		return newsList;
	}
	
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
	// 搜收藏列表     collect_list.action

	public String list (){
		
		if (session.get("userId")!=null) {
			String userId = session.get("userId").toString();
			newsList=collectService.getCollectList(userId, page, 8);
			user = userService.getUserBaseInfo(userId);
			return "collect_list";
		}
	   		return LOGIN;			
	} 
	
	//发送ajax的返回值
	 public void sendMsg(String content) {      
	       HttpServletResponse response = ServletActionContext.getResponse();      
	       response.setCharacterEncoding("UTF-8");      
	       try {
			response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("catch");
			e.printStackTrace();
		}
	   } 
	// 添加收藏     collect_add.action 
	public void add (){		
		    String userId = session.get("userId").toString();
			if(userId==null || collect.getNews().getId()==null){
	    		sendMsg("fail");
	    	}
			else{
				collect.setUserId(session.get("userId").toString());
				boolean collboo=collectService.addCollect(collect);
	    		if (collboo) {
	    			sendMsg("success");
	    		} else {
	    			sendMsg("fail");
	    		}
	    	}
		}
	   				
		
	// 取消收藏   collect_cancel.action 
	public void cancel (){
		   String userId = session.get("userId").toString();
		   System.out.println(collect.getNews().getId());
			if(userId==null || collect.getNews().getId()==null){
	    		sendMsg("fail");
	    	}
			else{
			boolean collboo=collectService.deleteCollect(userId,collect.getNews().getId());
			
			if (collboo) {
				sendMsg("success");
				
			}else {
				sendMsg("fail");
			}
			
	    	}		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if (collect!=null) {
			this.collect=new Collect();			
		}
		return collect;
	}
	
}
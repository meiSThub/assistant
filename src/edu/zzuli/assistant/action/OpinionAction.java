package edu.zzuli.assistant.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.zzuli.assistant.bean.Opinion;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.OpinionService;
import edu.zzuli.assistant.service.impl.OpinionServiceImpl;

public class OpinionAction extends ActionSupport implements SessionAware{

	private OpinionService opService=new OpinionServiceImpl();
	private List<Opinion> opList;
	private User user;
	private Opinion op;
	private int page = 1;// 评论当前页数 默认第一页
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Opinion getOp() {
		return op;
	}

	public void setOp(Opinion op) {
		this.op = op;
	}

	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	public List<Opinion> getOpList() {
		return opList;
	}

	public void setOpList(List<Opinion> opList) {
		this.opList = opList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String add(){
		
		if(session.get("userId")!=null){
			op.setAuthorId(session.get("userId").toString());
			op.setAuthorName(session.get("userName").toString());
			op.setPostTime(new Date());
			boolean result=opService.add(op);
			if(result){
				return "";
			}
		}
		return LOGIN;
	}
	
	public String list(){
		if(session.get("id")!=null){
			opList=opService.list(page, 8);
			if(opList!=null){
				return "opinion_list";
			}
		}
		return "fail";
	}
}

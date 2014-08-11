package edu.zzuli.assistant.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.service.NoticeService;
import edu.zzuli.assistant.service.impl.NoticeServiceImpl;

public class NoticeAction extends ActionSupport implements SessionAware{


	private NoticeService noticeService =new NoticeServiceImpl();
	private List<Notice> noticeList;
	private Notice notice ;
	private int page =1;//评论当前页数 默认第一页
	private String picList[];
	private Map<String,Object> session;
	
	public String[] getPicList() {
		return picList;
	}

	public void setPicList(String[] picList) {
		this.picList = picList;
	}
	public List<Notice> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	
	public String detail(){
		notice = noticeService.selectById(notice.getId());
		
		if(notice.getNoticePics()!=null){
			
			picList = notice.getNoticePics().split(";");
		}
		if(notice!=null){
			
			return "detail_success";
		}
		return null;
	}
	
	// 列表
	public String list(){
		noticeList=noticeService.getNoticList(page, 8);
		return "list_success";
	}
	
	public String adList(){
		if(session.get("id")!=null){
			noticeList=noticeService.getNoticList(page, 8);
			return "list_success";
		}
		return "fail";
	}
	
	public String delete(){
		if(session.get("id")!=null){
			boolean result=noticeService.deleteById(notice.getId());
			if(result){
				return "delete_success";
			}
		}
		return  null;
	}
}

package edu.zzuli.assistant.api.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.service.NoticeService;
import edu.zzuli.assistant.service.impl.NoticeServiceImpl;

public class NoticeAction extends ActionSupport{
	
	private NoticeService noticeService =new NoticeServiceImpl();
	private List<Notice> noticeList;
	private Notice notice ;
	private int page =1;//评论当前页数 默认第一页
	private String picList[];
	
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
	public void  list(){
		noticeList=noticeService.getNoticList(page, 3);
		write(noticeList);
	}
	
	public void write(Object object) {
		HttpServletResponse response = ServletActionContext.getResponse();  
		/*
		 * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码),
		 * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会
		 * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。
		 * */
		response.setContentType("text/html;charset=utf-8");
		//response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
			  .create();
			String jsonString  = gson.toJson(noticeList); //
			out.println(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(out!=null){
				out.flush();
				out.close();
			}
		}


	}

}

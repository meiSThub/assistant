package edu.zzuli.assistant.action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.service.NewsService;
import edu.zzuli.assistant.service.NoticeService;
import edu.zzuli.assistant.service.impl.NewsServiceImpl;
import edu.zzuli.assistant.service.impl.NoticeServiceImpl;

public class Index extends ActionSupport {
	
	private NoticeService noticeService;
	private NewsService newsService ;
	private List<Notice> noticeList;
	private List<News> newsList;
	
	public List<Notice> getNoticeList() {
		return noticeList;
	}
	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	@Override
	public String execute() throws Exception {
		
		// TODO Auto-generated method stub
		noticeService = new NoticeServiceImpl();
		newsService = new NewsServiceImpl();
		// 获取公告栏信息 3条
		noticeList=noticeService.getNoticList(1, 3);
		// 获取 最新的5条 news
		newsList= newsService.getNewsList(1, 5);
		return super.execute();
	}
	
}

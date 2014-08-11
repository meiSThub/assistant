package edu.zzuli.assistant.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zzuli.assistant.bean.Comment;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.CommentService;
import edu.zzuli.assistant.service.NewsService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.CommentServiceImpl;
import edu.zzuli.assistant.service.impl.NewsServiceImpl;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class NewsAction extends ActionSupport implements ModelDriven,
		SessionAware {

	private NewsService newsService = new NewsServiceImpl();
	private CommentService commentService = new CommentServiceImpl();
	private UserService userService = new UserServiceImpl();
	private Map<String, Object> session;
	private News news;
	private List<Comment> commentList;
	private List<News> newsList;
	private String picList[];
	private User tempUser;// news中有 也有user防止重复
	private int page = 1;// 评论当前页数 默认第一页

	public User getTempUser() {
		return tempUser;
	}

	public void setTempUser(User tempUser) {
		this.tempUser = tempUser;
	}

	public String[] getPicList() {
		return picList;
	}

	public void setPicList(String[] picList) {
		this.picList = picList;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
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

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if (news == null) {
			news = new News();
		}
		return news;
	}

	// 详情 (news_detail.action)
	public String detail() {

		news = newsService.getNews(news.getId());
		if (news.getNewsPics() != null) {

			picList = news.getNewsPics().split(";");
		}

		if (news != null) {
			commentList = commentService.getNewsCommentList(news.getId(), page,
					8);
			return "news_detail";
		}
		return ERROR;
	}

	// 教师发的news (news_teacher.action)
	public String teacher() {

		newsList = newsService.getStatusNews(User.STATUS_TREACHER, page, 8);
		return "news_teacher";
	}
	//管理员页面中的教师发的news列表
	public String adTeacher(){
		if(session.get("id")!=null){
			newsList = newsService.getStatusNews(User.STATUS_TREACHER, page, 8);
			return "news_teacher";
		}
		return "fail";
	}

	// 公众号发的news (news_publicnum.action)
	public String publicnum() {
		newsList = newsService.getStatusNews(User.STATUS_PUBLIC, page, 8);
		return "news_public";
	}
	//管理员页面中的 公众号发的news列表
	public String adPublicnum(){
		if(session.get("id")!=null){
			newsList = newsService.getStatusNews(User.STATUS_PUBLIC, page, 8);
			return "news_public";
		}
		return "fail";
	}

	// 关注的人的 news (news_follow.action)
	public String follow() {
		if (session.get("userId") != null) {
			String userId = session.get("userId").toString();
			newsList = newsService.getFollowNews(userId, page, 8);
			tempUser = userService.getUserBaseInfo(userId);
			return "news_follow";
		}
		return LOGIN;
	}

	// 用户获取自己所发的消息(news_self.action)
	public String self() {
		if (session.get("userId") != null) {
			String userId = session.get("userId").toString();
			newsList = newsService.getSelfNews(userId, page, 8);
			tempUser = userService.getUserBaseInfo(userId);
			return "news_self";
		}
		return LOGIN;

	}

	// 发帖action (news_post.action) 要设置token 防止重复提交
	public String post() {
		if (session.get("userId") != null
				&& Short.parseShort((session.get("status").toString())) != User.STATUS_STUDENT) {
			// 教师 可以发帖 跳转到发帖页面
			tempUser = userService.getUserBaseInfo(session.get("userId")
					.toString());

			return "news_post";
		} else {
			// 没有登录 跳转到首页
		}
		return LOGIN;
	}

	public String send() {

		if (session.get("userId") != null
				&& Short.parseShort((session.get("status").toString())) != User.STATUS_STUDENT) {
			// 教师 可以发帖 跳转到发帖页面
			User user = new User();
			user.setId(session.get("userId").toString());
			news.setUser(user);
			news.setAuthorName(session.get("userName").toString());
			news.setPostTime(new Date());
			if (news.getTitle().length() == 0 || news.getTitle().length() > 16) {
				return "comment_replyValidate";
			} else {
				HttpServletRequest request = ServletActionContext.getRequest();
				String imagePath = request.getParameter("pic_list");
				if (imagePath != null && imagePath != "") {
					imagePath = imagePath.substring(1, imagePath.length());
					news.setNewsPics(imagePath);
				}
			}
			new NewsServiceImpl().PublishNews(news);
			return "post_success";
		} else {
			// 没有登录 跳转到首页
			return LOGIN;
		}
	}
	public String delete(){
		
		if(session.get("id")!=null){
			boolean result=newsService.delteNews(session.get("id").toString(), news.getId());
			if(result)
				return "delete_success";
		}
		return "adminlogin";
	}
}

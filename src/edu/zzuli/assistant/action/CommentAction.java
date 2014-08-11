package edu.zzuli.assistant.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.zzuli.assistant.bean.Comment;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;
import edu.zzuli.assistant.service.CommentService;
import edu.zzuli.assistant.service.UserService;
import edu.zzuli.assistant.service.impl.CommentServiceImpl;
import edu.zzuli.assistant.service.impl.UserServiceImpl;

public class CommentAction extends ActionSupport implements ModelDriven ,SessionAware{
	
	private CommentService commentService = new CommentServiceImpl();
	private UserService userService=new UserServiceImpl();
	private Map<String, Object> session;
	private List<Comment> commentList;
	private Comment comment;
	private int page = 1;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Comment getComment() {
		return comment;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}

	public int getPage() {
		return page;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(comment ==null){
			this.comment = new Comment();
		}
		return comment;
	}
	
	
	//comment_self.acion 评论我的
	public String reply(){
		
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			commentList =  commentService.getReplyCommentList(userId,page,8);
			user = userService.getUserBaseInfo(userId);
			return "comment_reply";
		}
		return null;
		
	}
	
	//comment_other.acion 我的评论(评论他人)
	public String other(){
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			commentList =  commentService.getUserCommentList(userId,page,8);
			user = userService.getUserBaseInfo(userId);
			return "comment_other";
		}
		return null;
		
	}
	//comment_add.acion 添加一条评论
	public String add(){
		if(session.get("userId")!=null){
			String userId= session.get("userId").toString();
			comment.setAuthorId(userId);
			comment.setAuthorName(session.get("userName").toString());
			comment.setPostTime(new Date());
			//System.out.println(comment.getReplyId());
			commentService.addComment(comment);
//			System.out.println(comment.getReplyName()+"xxxxxxxxxx");
			return "news_detail";
		}
		return LOGIN;
		
	}
	//在“查看评论”中回复他人
	public String addReply(){
		String userId=session.get("userId").toString();
		comment.setAuthorId(userId);
		comment.setAuthorName(session.get("userName").toString());
		comment.setPostTime(new Date());
		if (comment.getContent().length()==0) {
			
			return "comment_replyReply";//我的评论中的回复
		}else {
			commentService.addComment(comment);
			return "comment_addReply";
		}		
	}
}

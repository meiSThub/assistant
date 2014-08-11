package edu.zzuli.assistant.service;

import java.util.List;

import edu.zzuli.assistant.bean.Comment;

public interface CommentService {

	/**
	 * @Description 添加一条   评论Comment
	 * @param comment 对象
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean addComment(Comment comment);
	
	/**
	 * @Description 删除一条  评论 Comment  这个功能，能不能用上待定
	 * @param  commentId
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean deleteComment(int commentId);
	
	
	/**
	 * @Description  查询消息的所有 评论
	 * @param  newsId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Comment>
	 */
	public  abstract List<Comment> getNewsCommentList(int newsId,int pageNum, int PageSize);
	
	/**
	 * @Description  查询用户做出的的所有 评论
	 * @param  userId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Comment>
	 */
	public  abstract List<Comment> getUserCommentList(String userId,int pageNum, int PageSize);
	
	/**
	 * @Description  查询用户收到的所有回复
	 * @param  userId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Comment>
	 */
	public  abstract List<Comment> getReplyCommentList(String userId,int pageNum, int PageSize);
}

package edu.zzuli.assistant.dao;

import java.util.List;

import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.Comment;
import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;

/**   
 * @Description: CollectDao 所有评论的接口
 * @author MR.Wang  
 * @date 2014-7-23 下午2:26:11 
 * @version V1.0   
 */ 
public interface CommentDao {
	
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
	public  abstract List<Comment> selectNewsCommentList(int newsId,int pageNum, int PageSize);
	
	/**
	 * @Description  查询用户做出的的所有 评论
	 * @param  userId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Comment>
	 */
	public  abstract List<Comment> selectUserCommentList(String userId,int pageNum, int PageSize);
	
	/**
	 * @Description  查询用户收到的所有回复
	 * @param  userId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Comment>
	 */
	public  abstract List<Comment> selectReplyCommentList(String userId,int pageNum, int PageSize);
	

	

}

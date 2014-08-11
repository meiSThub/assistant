package edu.zzuli.assistant.dao;

import java.util.List;
import edu.zzuli.assistant.bean.News;


/**   
 * @Description: 
 * @author MR.Wang  
 * @date 2014-7-23 下午12:50:53 
 * @version V1.0   
 */ 
public interface NewsDao {
	
	/**
	 * @Description 存入一条信息
	 * @param news 消息对象
	 * @return boolean true 标识成功 false标识失败
	 */
	public  abstract boolean add(News news);
	
	/**
	 * @Description  删除一条信息 
	 * @param newsId 消息对象的主键
	 * @return boolean true 标识成功 false标识失败
	 */
	public  abstract boolean delteById(int newsId);
	
	/**
	 * @Description 获取消息的详细信息 
	 * @param newsId 消息对象的主键
	 * @return News
	 */
	public  abstract News selectById(int newsId);
	
	/**
	 * @Description 获取消息的详细信息 
	 * @param newsId 消息对象的主键
	 * @return List<News>
	 */
	public  abstract List<News> selectByName(int name,int pageNum, int PageSize);
	
	/**
	 * @Description 评论数 +1
	 * @param newsId 消息对象的主键
	 * @param num 1代表加一条   -1 代表减一条
	 * @return List<News>
	 */
	public  abstract boolean updateCommnetNum(int newsId,int num);
	
	/**
	 * @Description 获取未登录时 的消息列表
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> selectNewsList(int pageNum, int PageSize);
	
	/**
	 * @Description 用户（教师，公众号）   获取自己历史所发的消息
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> selectSelfNews(String userId,int pageNum, int PageSize);
	
	/**
	 * @Description 获取用户登陆以后  获取所关注的人所发的消息
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> selectFollowNews(String userId,int pageNum, int PageSize);
	
	
	/**
	 * @Description 获取不同身份的人所发的  消息
	 * @param status 身份
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> selectStatusNews(short status, int pageNum, int PageSize);
	
/*	*//**
	 * @Description 更新某一条草稿
	 * @param news 对象
	 * @return List<News>
	 *//*
	public  abstract boolean updateDraft(News news);
	
	
	*//**
	 * @Description 发布某一条草稿
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 *//*
	public  abstract boolean publishDraft(int newsId);
	
	*//**
	 * @Description 获取用户的草稿箱的所有草稿
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 *//*
	public  abstract List<News> getDraftList(String userId,int pageNum, int PageSize);*/

}

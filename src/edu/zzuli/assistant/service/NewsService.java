package edu.zzuli.assistant.service;

import java.util.List;

import edu.zzuli.assistant.bean.News;

public interface NewsService {

	/**
	 * @Description 发布一条消息
	 * @param news 消息对象
	 * @return boolean true 标识成功 false标识失败
	 */
	public  abstract boolean PublishNews(News news);
	
	/**
	 * @Description  删除一条信息 
	 * @param UserId 用户Id
	 * @param newsId 消息对象的主键
	 * @return boolean true 标识成功 false标识失败
	 */
	public  abstract boolean delteNews(String UserId,int newsId);
	
	/**
	 * @Description 获取消息的详细信息 
	 * @param newsId 消息对象的主键
	 * @return List<News>
	 */
	public  abstract News getNews(int newsId);
	
	/**
	 * @Description 根据名称获取news 
	 * @param newsId 消息对象的主键
	 * @return List<News>
	 */
	public  abstract  List<News> getNewsByName(int name,int pageNum, int PageSize);
	
	/**
	 * @Description 获取未登录时 的消息列表
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> getNewsList(int pageNum, int PageSize);
	
	/**
	 * @Description 用户（教师，公众号）   获取自己历史所发的消息
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> getSelfNews(String userId,int pageNum, int PageSize);
	
	/**
	 * @Description 获取用户登陆以后  获取所关注的人所发的消息
	 * @param userId 用户Id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> getFollowNews(String userId,int pageNum, int PageSize);
	
	
	/**
	 * @Description 获取不同身份的人所发的  消息
	 * @param status 身份
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<News>
	 */
	public  abstract List<News> getStatusNews(short status, int pageNum, int PageSize);

}

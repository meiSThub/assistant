package edu.zzuli.assistant.dao;

import java.util.List;

import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.User;

/**   
 * @Description: FollowDao 所有关注的接口
 * @author MR.Wang  
 * @date 2014-7-23 下午2:26:11 
 * @version V1.0   
 */ 
public interface FollowDao {
	
	/**
	 * @Description 添加关注
	 * @param follw 对象
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean add(Follow follw);
	
	/**
	 * @Description 删除一个关注（即取消关注）
	 * @param  follwId
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean deleteById(String fansId,String startId);
	
	
	/**
	 * @Description  获取已关注的人关注列表(只需要知道userId 所关注的人id 用来判断是否已关注过该人)
	 * @param  userId
	 * @return List<Follw>
	 */
	public  abstract List<Follow> selectStartList(String userId);
	
	/**
	 * @Description  获取粉丝列表 (需要知道userId 的粉丝的详细信息)
	 * @param  userId  用户id
	 * @param  pageNum  当前页数
	 * @param  PageSize  分页大小
	 * @return List<User> 
	 */
	public  abstract List<User> selectFansUserList(String userId,int pageNum,int PageSize);
	
	/**
	 * @Description  获取关注列表(需要知道userId 所关注的人的人的详细信息)
	 * @param  userId  用户id
	 * @param  pageNum  当前页数
	 * @param  PageSize  分页大小
	 * @return List<User> 
	 */
	public  abstract List<User> selectStartUserList(String userId,int pageNum,int PageSize);
	

}

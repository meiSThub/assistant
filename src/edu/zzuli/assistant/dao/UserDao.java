package edu.zzuli.assistant.dao;

import java.util.List;

import edu.zzuli.assistant.bean.User;

/**   
 * @Title dao 层的命名应该按照  数据库操作命名
 * @Description: UserDao
 * @author MR.Wang  
 * @date 2014-7-23 下午12:52:29 
 * @version V1.0   
 */ 
public interface UserDao {
	
	
	/**
	 * @Description 添加用户
	 * @param user 用户对象
	 * @return boolean 
	 */
	public boolean add(User user);
	
	/**
	 * @Description 是否存在该用户
	 * @param user 用户对象(只需要用户名和密码)
	 * @return boolean true表示用户名密码匹配    false用户名密码不匹配
	 */
	public  abstract boolean exists(User user);
	
	/**
	 * @Description 查询某个用户的所有信息
	 * @param user 用户对象(只需要用户名和密码)
	 * @return User 对象
	 */
	public  abstract User selectById(String userId);
	
	/**
	 * @Description 查询某个用户的所有信息
	 * @param name 用户名
	 * @return User 对象
	 */
	public  abstract List<User>  selectByName(String name, short status,int pageNum, int PageSize);
	
	
	/**
	 * @Description 更新历史发布消息条数 +1
	 * @param userId 用户Id
	 * @param num 1代表加一条   -1 代表减一条
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public  abstract boolean updateNewsNum(String userId,int num);
	

	
	/**
	 * @Description 更新收到的评论条数 +1
	 * @param userId 用户Id
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public  abstract boolean updateReplyNum(String userId);
	
	
	/**
	 * @Description 清空收到的评论条数
	 * @param userId 用户Id
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public  abstract boolean clearReplyNum(String userId);
	
	
	/**
	 * @Description 更新用户头像
	 * @param userId 用户id
	 * @param headUrL 用户头像地址
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public  abstract boolean updateHead(String userId,String headUrL);
	
	/**
	 * @Description 更新用户简介
	 * @param intro 用户对象简介信息
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public  abstract boolean updateIntro(String userId,String intro);
	
	/**
	 * @Description 更新用户密码   调用此方法前先调用exists()方法 判断原始密码
	 * @param password 新密码 
	 * @return boolean true表示修改成功    false不存在修改失败
	 */
	public  abstract boolean updatePassword(String userId,String newPassword);
	
	
	/**
	 * @Description 查询公众号列表
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return User 对象
	 */
	public  abstract List<User> selectPublicList(int pageNum, int PageSize);
	
	/**
	 * @Description 查询老师列表
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return User 对象
	 */
	public  abstract List<User> selectTeacherList(int pageNum, int PageSize);
	
	/**
	 * @Description 更新关注的人数+1
	 * @param userId 用户的ID
	 * @param followNum 关注的人数，如果followNum=1则关注的人数+1，如果followNum=-1则关注的人数-1 
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public abstract boolean updateFollowNum(String userId,int followNum);
	
	/**
	 * @Description 关注的人数清空
	 * @param userId 用户的ID
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public abstract boolean clearNewFollowNum(String userId);
	
	/**
	 * @Description 更新粉丝的人数
	 * @param userId 用户的ID
	 * @param fansNum  粉丝的人数，如果followmeNum=1则关注的人数+1，如果followmeNum=-1则关注的人数-1
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public abstract boolean updateFansNum(String userId,int fansNum);
	
	/**
	 * @Description 查询老师列表
	 * @param userId 用户的ID 
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public abstract boolean clearNewFansNum(String userId);
	
	/**
	 * @Description 查询老师列表
	 * @param userId 用户的ID
	 * @param newEmai  新的Email
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public abstract boolean updateEmail(String userId,String newEmail);
	
	/**
	 * @Description 查询数据库是否已经存在该邮箱
	 * @param email 邮箱
	 * @return boolean true 存在    false不存在
	 */
	public boolean hasThisEmail(String email);
}

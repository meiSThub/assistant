package edu.zzuli.assistant.service;

import java.util.List;

import edu.zzuli.assistant.bean.User;

/** 
 * @Title Service 层才是业务逻辑层  <br> 
 * 这一层是关键
 * @Description 用户service
 * @author MR.Wang  
 * @date 2014-7-23 下午8:16:39 
 * @version V1.0   
 */ 
public interface UserService {
	
	
	/**
	 * @Description 添加一个user
	 * @param user 用户对象 <br>
	 * 需要对user 的合法性进行校验
	 * @return boolean true表示登陆成功    false登陆失败
	 */
	
	
	public abstract boolean addUser(User user);
	/**
	 * @Description 登陆验证
	 * @param user 用户对象 <br>
	 * 需要对user 的合法性进行校验
	 * @return boolean true表示登陆成功    false登陆失败
	 */
	public abstract boolean login(User user);
	
	
	/**
	 * @Description 获取用户的基本信息
	 * @param userId 用户主键
	 * @return User 
	 */
	public abstract User getUserBaseInfo(String userId);
	
	
	/**
	 * @Description 根据用户名查询用户
	 * @param userId 用户主键
	 * @param status 身份
	 * @return User 
	 */
	public abstract List<User> getUserByName(String name,short status,int pageNum, int PageSize);

	/**
	 * @Description 更新用户头像
	 * @param userId 用户id
	 * @param headUrL 用户头像地址
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public  abstract boolean modifyHeadImg(String userId,String headUrL);
	
	/**
	 * @Description 修改用户简介
	 * @param userId 用户对象id
	 * @param intro 用户对象简介信息
	 * @return boolean true表示更换成功    false不存在更新失败
	 */
	public  abstract boolean modifyIntro(String userId,String intro);
	
	/**
	 * @Description 更新邮箱
	 * @param newEmai  新的Email
	 * @return boolean true表示更新成功    false不存在更新失败
	 */
	public abstract boolean updateEmail(User user);
	
	/**
	 * @Description 修改用户密码   调用此方法是要 判断原始密码是否正确
	 * @param user 对象
	 * @param newPassword 新密码 
	 * @return boolean true表示修改成功    false不存在修改失败
	 */
	public  abstract boolean modifyPassword(User user,String newPassword);
	
	/**
	 * @Description 获取公众号列表
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return User 集合对象
	 */
	public  abstract List<User> getPublicList(int pageNum, int PageSize);
	
	/**
	 * @Description 获取老师列表
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return User 集合对象
	 */
	public  abstract List<User> getTeacherList(int pageNum, int PageSize);
	
	/**
	 * @Description 查询数据库是否已经存在该邮箱
	 * @param email 邮箱
	 * @return boolean true 存在    false不存在
	 */
	public boolean hasThisEmail(String email);
}

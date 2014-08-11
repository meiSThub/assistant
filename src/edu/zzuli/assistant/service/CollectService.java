package edu.zzuli.assistant.service;

import java.util.List;

import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;

/**   
 * @Description: CollectService
 * @author MR.Wang  
 * @date 2014-7-23 下午2:26:11 
 * @version V1.0   
 */ 
public interface CollectService {
	
	/**
	 * @Description 添加一个一条Collect
	 * @param collect 对象
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean addCollect(Collect collect );
	
	/**
	 * @Description 删除一个Collect     删除收藏
	 * @param  collectId
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean deleteCollect(String userId, int newsId);
	
	
	/**
	 * @Description  获取收藏的消息
	 * @param  userId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Follw>
	 */
	public  abstract List<News> getCollectList(String userId,int pageNum, int PageSize);
	

	

}

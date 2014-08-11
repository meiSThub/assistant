package edu.zzuli.assistant.dao;

import java.util.List;

import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.User;

/**   
 * @Description: CollectDao 所有收藏的接口
 * @author MR.Wang  
 * @date 2014-7-23 下午2:26:11 
 * @version V1.0   
 */ 
public interface CollectDao {
	
	/**
	 * @Description 添加一个一条Collect
	 * @param collect 对象
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean add(Collect collect );
	
	/**
	 * @Description 删除一个Collect 即取消关注
	 * @param  collectId
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean deleteById(String userId, int newsId);
	
	
	/**
	 * @Description  获取收藏的消息
	 * @param  userId 用户id
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Follw>
	 */
	public  abstract List<News> selectList(String userId,int pageNum, int PageSize);
	

	

}

package edu.zzuli.assistant.dao;

import java.util.List;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.NewsPic;


/**   
 * @Description: 消息图片地址
 * @author MR.Wang  
 * @date 2014-7-23 下午12:50:53 
 * @version V1.0   
 */ 
public interface NewsPicDao {
	
	/**
	 * @Description 存入一张图片
	 * @param newsPic 图片对象
	 * @return boolean true 标识成功 false标识失败
	 */
	public  abstract boolean add(NewsPic newsPic);
	
	/**
	 * @Description  删除一张图片
	 * @param newsPicId 图片对象的主键
	 * @return boolean true 标识成功 false标识失败
	 */
	public  abstract boolean delteById(String newsPicUrl);
	
	
	/**
	 * @Description 获取消息的所有图片
	 * @param newsId 消息对象的主键
	 * @return List<NewsPic>
	 */
	public  abstract List<NewsPic> selectNewsPic(int newsId);


}

package edu.zzuli.assistant.dao;

import java.util.List;

import edu.zzuli.assistant.bean.Collect;
import edu.zzuli.assistant.bean.Follow;
import edu.zzuli.assistant.bean.News;
import edu.zzuli.assistant.bean.Notice;
import edu.zzuli.assistant.bean.User;

/**   
 * @Description: NoticeDao 所有通知的接口
 * @author MR.Wang  
 * @date 2014-7-23 下午2:26:11 
 * @version V1.0   
 */ 
public interface NoticeDao {
	
	/**
	 * @Description 发布一条Collect
	 * @param collect 对象
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean add(Notice notice );
	
	
	
	/**
	 * @Description 获取通知的详细信息 
	 * @param newsId 消息对象的主键
	 * @return List<News>
	 */
	public  abstract Notice selectById(int noticeId);
	
	/**
	 * @Description 删除通知 （要不要这个功能---待定）
	 * @param  collectId
	 * @return boolean true表示添加成功    false添加失败
	 */
	public  abstract boolean deleteById(int collectId);
	
	/**
	 * @Description  分页查找历史通知
	 * @param pageNum 页数
	 * @param PageSize  分页条数
	 * @return List<Follw>
	 */
	public  abstract List<Notice> selectNotic(int pageNum, int PageSize);
	

	

}

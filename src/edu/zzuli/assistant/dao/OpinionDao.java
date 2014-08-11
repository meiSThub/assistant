package edu.zzuli.assistant.dao;

import java.util.List;

import edu.zzuli.assistant.bean.Opinion;

public interface OpinionDao {

	/**
	 * 增加一条反馈信息
	 * @param op  反馈对象
	 * @return
	 */
	public abstract boolean add(Opinion op);
	/**
	 * 查询所有的反馈信息
	 * @param pageNum  页数
	 * @param PageSize 每页的数据条数
	 * @return
	 */
	public abstract List<Opinion> list(int pageNum,
			int PageSize);
}

package edu.zzuli.assistant.service;

import java.util.List;

import edu.zzuli.assistant.bean.Opinion;

public interface OpinionService {

	/**
	 * 添加反馈
	 * @param op 反馈对象
	 * @return
	 */
	public abstract boolean add(Opinion op);
	/**
	 * 
	 * @return
	 */
	public abstract List<Opinion> list(int pageNum,int PageSize);
}

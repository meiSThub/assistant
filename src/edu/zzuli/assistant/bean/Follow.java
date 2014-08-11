package edu.zzuli.assistant.bean;

/**
 * Follw entity. @author MyEclipse Persistence Tools
 */

public class Follow implements java.io.Serializable {

	// Fields

	private Integer id; // 主键
	private String fansId;//粉丝Id
	private String startId;//被关注的人Id
	
	public Follow() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFansId() {
		return fansId;
	}
	public void setFansId(String fansId) {
		this.fansId = fansId;
	}
	public String getStartId() {
		return startId;
	}
	public void setStartId(String startId) {
		this.startId = startId;
	}
	


}
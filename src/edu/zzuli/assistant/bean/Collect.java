package edu.zzuli.assistant.bean;

/**
 * Collect entity. @author MyEclipse Persistence Tools
 */

public class Collect implements java.io.Serializable {

	// Fields

	private Integer id;// 主键
	private String userId;// 主键
	private News news;// 消息 

	// Constructors

	/** default constructor */
	public Collect() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
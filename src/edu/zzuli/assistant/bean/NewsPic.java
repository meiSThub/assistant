package edu.zzuli.assistant.bean;

/**
 * NewsPic entity. @author MyEclipse Persistence Tools
 */

public class NewsPic implements java.io.Serializable {

	// Fields

	private String picUrl;
	private Integer newsId;

	// Constructors

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	/** default constructor */
	public NewsPic() {
	}

	


}
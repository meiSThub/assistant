package edu.zzuli.assistant.bean;

/**
 * NoticPic entity. @author MyEclipse Persistence Tools
 */

public class NoticePic implements java.io.Serializable {

	// Fields

	private String picUrl;
	private Notice notice;

	// Constructors

	/** default constructor */
	public NoticePic() {
	}

	/** full constructor */
	public NoticePic(String picUrl, Notice notice) {
		this.picUrl = picUrl;
		this.notice = notice;
	}

	// Property accessors

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Notice getNotice() {
		return this.notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

}
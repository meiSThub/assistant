package edu.zzuli.assistant.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String email;
	private String loginIp;
	private Set notices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public Admin(Integer id, String name, String password, String email,
			String loginIp, Set notices) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.loginIp = loginIp;
		this.notices = notices;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
	}

}
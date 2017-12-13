/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shiyan.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * shiyantestEntity
 * @author yangyang
 * @version 2017-12-13
 */
public class Demo-user extends DataEntity<Demo-user> {
	
	private static final long serialVersionUID = 1L;
	private String username;		// username
	private String pwd;		// pwd
	private String ulr;		// ulr
	
	public Demo-user() {
		super();
	}

	public Demo-user(String id){
		super(id);
	}

	@Length(min=0, max=255, message="username长度必须介于 0 和 255 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=1, max=255, message="pwd长度必须介于 1 和 255 之间")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Length(min=0, max=255, message="ulr长度必须介于 0 和 255 之间")
	public String getUlr() {
		return ulr;
	}

	public void setUlr(String ulr) {
		this.ulr = ulr;
	}
	
}
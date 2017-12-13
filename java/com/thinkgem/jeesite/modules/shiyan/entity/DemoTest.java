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
public class DemoTest extends DataEntity<DemoTest> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	
	public DemoTest() {
		super();
	}

	public DemoTest(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=3, message="age长度必须介于 0 和 3 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}
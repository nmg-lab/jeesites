/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shiyan.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.shiyan.entity.Demo-user;
import com.thinkgem.jeesite.modules.shiyan.dao.Demo-userDao;

/**
 * shiyantestService
 * @author yangyang
 * @version 2017-12-13
 */
@Service
@Transactional(readOnly = true)
public class Demo-userService extends CrudService<Demo-userDao, Demo-user> {

	public Demo-user get(String id) {
		return super.get(id);
	}
	
	public List<Demo-user> findList(Demo-user demo-user) {
		return super.findList(demo-user);
	}
	
	public Page<Demo-user> findPage(Page<Demo-user> page, Demo-user demo-user) {
		return super.findPage(page, demo-user);
	}
	
	@Transactional(readOnly = false)
	public void save(Demo-user demo-user) {
		super.save(demo-user);
	}
	
	@Transactional(readOnly = false)
	public void delete(Demo-user demo-user) {
		super.delete(demo-user);
	}
	
}
/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shiyan.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.shiyan.entity.DemoTest;

/**
 * shiyantestDAO接口
 * @author yangyang
 * @version 2017-12-13
 */
@MyBatisDao
public interface DemoTestDao extends CrudDao<DemoTest> {
	
}
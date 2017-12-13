/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.shiyan.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.shiyan.entity.DemoTest;
import com.thinkgem.jeesite.modules.shiyan.service.DemoTestService;

/**
 * shiyantestController
 * @author yangyang
 * @version 2017-12-13
 */
@Controller
@RequestMapping(value = "${adminPath}/shiyan/demoTest")
public class DemoTestController extends BaseController {

	@Autowired
	private DemoTestService demoTestService;
	
	@ModelAttribute
	public DemoTest get(@RequestParam(required=false) String id) {
		DemoTest entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demoTestService.get(id);
		}
		if (entity == null){
			entity = new DemoTest();
		}
		return entity;
	}
	
	@RequiresPermissions("shiyan:demoTest:view")
	@RequestMapping(value = {"list", ""})
	public String list(DemoTest demoTest, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DemoTest> page = demoTestService.findPage(new Page<DemoTest>(request, response), demoTest); 
		model.addAttribute("page", page);
		return "modules/shiyan/demoTestList";
	}

	@RequiresPermissions("shiyan:demoTest:view")
	@RequestMapping(value = "form")
	public String form(DemoTest demoTest, Model model) {
		model.addAttribute("demoTest", demoTest);
		return "modules/shiyan/demoTestForm";
	}

	@RequiresPermissions("shiyan:demoTest:edit")
	@RequestMapping(value = "save")
	public String save(DemoTest demoTest, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demoTest)){
			return form(demoTest, model);
		}
		demoTestService.save(demoTest);
		addMessage(redirectAttributes, "保存user成功");
		return "redirect:"+Global.getAdminPath()+"/shiyan/demoTest/?repage";
	}
	
	@RequiresPermissions("shiyan:demoTest:edit")
	@RequestMapping(value = "delete")
	public String delete(DemoTest demoTest, RedirectAttributes redirectAttributes) {
		demoTestService.delete(demoTest);
		addMessage(redirectAttributes, "删除user成功");
		return "redirect:"+Global.getAdminPath()+"/shiyan/demoTest/?repage";
	}

}
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
import com.thinkgem.jeesite.modules.shiyan.entity.Demo-user;
import com.thinkgem.jeesite.modules.shiyan.service.Demo-userService;

/**
 * shiyantestController
 * @author yangyang
 * @version 2017-12-13
 */
@Controller
@RequestMapping(value = "${adminPath}/shiyan/demo-user")
public class Demo-userController extends BaseController {

	@Autowired
	private Demo-userService demo-userService;
	
	@ModelAttribute
	public Demo-user get(@RequestParam(required=false) String id) {
		Demo-user entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = demo-userService.get(id);
		}
		if (entity == null){
			entity = new Demo-user();
		}
		return entity;
	}
	
	@RequiresPermissions("shiyan:demo-user:view")
	@RequestMapping(value = {"list", ""})
	public String list(Demo-user demo-user, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Demo-user> page = demo-userService.findPage(new Page<Demo-user>(request, response), demo-user); 
		model.addAttribute("page", page);
		return "modules/shiyan/demo-userList";
	}

	@RequiresPermissions("shiyan:demo-user:view")
	@RequestMapping(value = "form")
	public String form(Demo-user demo-user, Model model) {
		model.addAttribute("demo-user", demo-user);
		return "modules/shiyan/demo-userForm";
	}

	@RequiresPermissions("shiyan:demo-user:edit")
	@RequestMapping(value = "save")
	public String save(Demo-user demo-user, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, demo-user)){
			return form(demo-user, model);
		}
		demo-userService.save(demo-user);
		addMessage(redirectAttributes, "保存usertext成功");
		return "redirect:"+Global.getAdminPath()+"/shiyan/demo-user/?repage";
	}
	
	@RequiresPermissions("shiyan:demo-user:edit")
	@RequestMapping(value = "delete")
	public String delete(Demo-user demo-user, RedirectAttributes redirectAttributes) {
		demo-userService.delete(demo-user);
		addMessage(redirectAttributes, "删除usertext成功");
		return "redirect:"+Global.getAdminPath()+"/shiyan/demo-user/?repage";
	}

}
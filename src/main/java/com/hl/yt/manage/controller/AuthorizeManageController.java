package com.hl.yt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.yt.common.R;
import com.hl.yt.manage.dto.AuthorizeManageDTO;
import com.hl.yt.manage.service.AuthorizeManageService;

@Controller
@RequestMapping("manage/authorize")
public class AuthorizeManageController {
	@Autowired
	AuthorizeManageService authorizeService;

	@RequestMapping("add")
	public String add() {
		return "manage/authorize";
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, String name, String wechatNumber, String phoneNumber, String address,
			int proxyLevel, String startDate, String endDate) {
		int result = 0;
		if (id == 0)
			result = authorizeService.save(name,wechatNumber, phoneNumber, address, proxyLevel, startDate,endDate);
		else
			result = authorizeService.update(id, name,wechatNumber, phoneNumber, address, proxyLevel,
					 startDate,endDate);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		AuthorizeManageDTO authorize = authorizeService.getAuthorize(id);
		model.addAttribute("authorize", authorize);
		return "manage/authorize";
	}

	@RequestMapping("show/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		AuthorizeManageDTO authorize = authorizeService.getAuthorize(id);
		model.addAttribute("authorize", authorize);
		model.addAttribute("showFlag", 1);
		return "manage/authorize";
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = authorizeService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}
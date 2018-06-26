package com.hl.yt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.yt.common.Base;
import com.hl.yt.common.R;
import com.hl.yt.manage.dto.ManagerDTO;
import com.hl.yt.manage.service.ManagerService;
import com.hl.yt.util.SecretUtil;

@Controller
@RequestMapping("manage")
public class MamagerController extends Base {

	@Autowired
	ManagerService managerService;

	@RequestMapping("login")
	public String login() {
		return "manage/login";
	}

	@RequestMapping("managerLogin")
	@ResponseBody
	public R managerLogin(String username, String password) {
		ManagerDTO manager = managerService.getManager(username, SecretUtil.encrypt(password));
		if (manager != null) {
			addSession("manager", manager);
			return R.ok();
		}
		return R.error("用户名或密码错误！");
	}

}
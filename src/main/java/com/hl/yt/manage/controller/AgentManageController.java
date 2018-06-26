package com.hl.yt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.yt.common.R;
import com.hl.yt.manage.service.AgentManageService;

@Controller
@RequestMapping("manage/agent")
public class AgentManageController {
	@Autowired
	AgentManageService agentManageService;

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, String content) {
		int result = 0;
		if (id == 0)
			result = agentManageService.save(content);
		else
			result = agentManageService.update(id, content);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}
}
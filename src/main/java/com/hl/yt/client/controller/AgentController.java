package com.hl.yt.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.yt.client.dto.AgentDTO;
import com.hl.yt.client.service.AgentService;


@Controller
@RequestMapping("jiamengdaili")
public class AgentController {
	@Autowired
	AgentService agentService;

	
	@RequestMapping("index")
	public String queryAgent(Model model) {
		AgentDTO agent = agentService.getAgent();
		model.addAttribute("agent", agent);
		return "client/jiamengdaili";
	}
}
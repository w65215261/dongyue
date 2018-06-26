package com.hl.yt.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.yt.client.dto.CallUsDTO;
import com.hl.yt.client.service.CallUsService;


@Controller
@RequestMapping("lianxiwomen")
public class CallUsController {
	@Autowired
	CallUsService callUsService;

	@RequestMapping("index")
	public String getDetail(Model model) {
		CallUsDTO callUs = callUsService.getCallUs();
		model.addAttribute("callUs", callUs);
		return "client/lianxiwomen";
	}
}
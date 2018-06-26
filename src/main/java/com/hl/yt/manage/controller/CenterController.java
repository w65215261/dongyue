package com.hl.yt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.yt.common.Base;
import com.hl.yt.manage.dto.AgentManageDTO;
import com.hl.yt.manage.dto.AuthorizeManageDTO;
import com.hl.yt.manage.dto.BannerDTO;
import com.hl.yt.manage.dto.CallUsManageDTO;
import com.hl.yt.manage.dto.IndexContentManageDTO;
import com.hl.yt.manage.service.AgentManageService;
import com.hl.yt.manage.service.AuthorizeManageService;
import com.hl.yt.manage.service.BannerService;
import com.hl.yt.manage.service.CallUsManageService;
import com.hl.yt.manage.service.IndexContentManageService;

@Controller
@RequestMapping("manage")
public class CenterController extends Base {

	@Autowired
	BannerService bannerService;
	
	@Autowired
	AgentManageService agentManageService;
	
	@Autowired
	CallUsManageService callUsManageService;
	
	@Autowired
	AuthorizeManageService authorizeService;
	
	@Autowired
	IndexContentManageService IndexContentManageService;

	@RequestMapping("center")
	public String center() {
		return "manage/center";
	}

	@RequestMapping("shouyeguanli")
	public String shouyeguanli(Model model) {
		List<BannerDTO> banners = bannerService.getBannerList();
		IndexContentManageDTO indexContent = IndexContentManageService.getContent();
		model.addAttribute("indexContent", indexContent);
		model.addAttribute("banners", banners);
		return "manage/shouyeguanli";
	}
	
	@RequestMapping("jiamengdailiguanli")
	public String jiamengdailiguanli(Model model) { 
		AgentManageDTO agent = agentManageService.getAgent();
		model.addAttribute("agent", agent);
		return "manage/agent";
	}
	
	@RequestMapping("lianxiwomenguanli")
	public String lianxiwomen(Model model) { 
		CallUsManageDTO callUs = callUsManageService.getCallus();
		model.addAttribute("callUs", callUs);
		return "manage/callUs";
	}
	
	@RequestMapping("shouquanchaxunguanli/{currPage}")
	public String shouquanchaxunguanli(Model model, @PathVariable("currPage") int currPage) {
		List<AuthorizeManageDTO> authorizes = authorizeService.getAuthorizes((currPage - 1) * 10, 10);
		int count = authorizeService.getAuthorizeCount();
		model.addAttribute("currPage", currPage);
		model.addAttribute("count", count);
		model.addAttribute("pageCount", page(count, 10));
		model.addAttribute("authorizes", authorizes);
		return "manage/shouquanchaxunguanli";
	}
}
package com.hl.yt.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.yt.client.dto.HomeContentDTO;
import com.hl.yt.client.dto.HomeDTO;
import com.hl.yt.client.service.HomeContentService;
import com.hl.yt.client.service.HomeService;


@Controller
public class HomeController {
	@Autowired
	HomeService homeService;
	@Autowired
	HomeContentService homeContentService;

	@RequestMapping("")
	public String queryBanners(Model model) {
		List<HomeDTO> banners = homeService.getBanners();// banner
		HomeContentDTO content = homeContentService.getContent();
		model.addAttribute("content", content);
		model.addAttribute("banners", banners);
		return "client/ytIndex";
	}
}
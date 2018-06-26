package com.hl.yt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.yt.common.R;
import com.hl.yt.manage.dto.BannerDTO;
import com.hl.yt.manage.service.BannerService;

@Controller
@RequestMapping("manage/banner")
public class BannerController {

	@Autowired
	BannerService bannerService;

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, String title, String content, String banner, int imgId) {
		int result = 0;
		if (id == 0)
			result = bannerService.save(title, content, banner, imgId);
		else
			result = bannerService.update(id, title, content, banner, imgId);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
	
	@RequestMapping("getBanner/{id}")
	@ResponseBody
	public R getBanner(@PathVariable("id") int id) {
		BannerDTO banner = bannerService.getBanner(id);
		return R.ok().put("banner", banner);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = bannerService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}
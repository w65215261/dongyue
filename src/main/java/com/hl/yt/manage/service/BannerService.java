package com.hl.yt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.manage.dao.BannerDao;
import com.hl.yt.manage.dto.BannerDTO;

@Service
public class BannerService {
	@Autowired
	BannerDao bannerDao;

	public int save(String title, String content, String banner, int imgId) {
		return bannerDao.save(title, content, banner, imgId);
	}

	public List<BannerDTO> getBannerList() {
		return bannerDao.getBannerList();
	}

	public BannerDTO getBanner(int id) {
		return bannerDao.getBanner(id);
	}

	public int del(int id) {
		return bannerDao.del(id);
	}

	public int update(int id, String title, String content, String banner, int imgId) {
		return bannerDao.update(id, title, content, banner, imgId);
	}
}
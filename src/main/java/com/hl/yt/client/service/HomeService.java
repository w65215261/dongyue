package com.hl.yt.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.client.dao.HomeDao;
import com.hl.yt.client.dto.HomeDTO;

@Service
public class HomeService {
	@Autowired
	HomeDao homeDao;

	public List<HomeDTO> getBanners() {
		return homeDao.getBanners();
	}
}
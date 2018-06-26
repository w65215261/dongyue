package com.hl.yt.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.client.dao.HomeContentDao;
import com.hl.yt.client.dto.HomeContentDTO;

@Service
public class HomeContentService {
	@Autowired
	HomeContentDao homeContentDao;

	public HomeContentDTO getContent() {
		return homeContentDao.getContent();
	}
}
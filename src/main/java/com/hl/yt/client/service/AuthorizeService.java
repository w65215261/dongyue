package com.hl.yt.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.client.dao.AuthorizeDao;
import com.hl.yt.client.dto.AuthorizeDTO;

@Service
public class AuthorizeService {
	@Autowired
	AuthorizeDao authorizeDao;

	public AuthorizeDTO getAuthorizes(String parameter) {
		if ("".equals(parameter) || parameter == null) {
			return null;
		} else {
			return authorizeDao.getAuthorizes(parameter);
		}
	}

}
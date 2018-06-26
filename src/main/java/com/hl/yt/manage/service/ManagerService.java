package com.hl.yt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.manage.dao.ManagerDao;
import com.hl.yt.manage.dto.ManagerDTO;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	public ManagerDTO getManager(String username, String password) {
		return managerDao.getManager(username, password);
	}
}

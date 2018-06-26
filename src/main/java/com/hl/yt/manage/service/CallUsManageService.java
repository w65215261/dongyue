package com.hl.yt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.manage.dao.CallUsManageDao;
import com.hl.yt.manage.dto.CallUsManageDTO;

@Service
public class CallUsManageService {
	@Autowired
	CallUsManageDao callUsManageDao;

	public int save(String content) {
		return callUsManageDao.save(content);
	}

	public int update(int id,String content) {
		return callUsManageDao.update(id,content);
	}

	public CallUsManageDTO getCallus() {
		CallUsManageDTO callUs = callUsManageDao.getCallus();
		return callUs;
	}
}
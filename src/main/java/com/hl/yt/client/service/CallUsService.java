package com.hl.yt.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.client.dao.CallUsDao;
import com.hl.yt.client.dto.CallUsDTO;

@Service
public class CallUsService {
	@Autowired
	CallUsDao callUsDao;

	public CallUsDTO getCallUs() {
		return callUsDao.getCallUs();
	}
}
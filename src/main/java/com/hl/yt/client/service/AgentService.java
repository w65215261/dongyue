package com.hl.yt.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.client.dao.AgentDao;
import com.hl.yt.client.dto.AgentDTO;

@Service
public class AgentService {
	@Autowired
	AgentDao agentDao;

	public AgentDTO getAgent() {
		return agentDao.getAgent();
	}
}
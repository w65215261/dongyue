package com.hl.yt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.manage.dao.AgentManageDao;
import com.hl.yt.manage.dto.AgentManageDTO;

@Service
public class AgentManageService {
	@Autowired
	AgentManageDao agentManageDao;

	public int save(String content) {
		return agentManageDao.save(content);
	}

	public int update(int id,String content) {
		return agentManageDao.update(id,content);
	}

	public AgentManageDTO getAgent() {
		AgentManageDTO agent = agentManageDao.getAgent();
		return agent;
	}
}
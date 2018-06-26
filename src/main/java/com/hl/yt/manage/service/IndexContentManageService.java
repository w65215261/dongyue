package com.hl.yt.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.manage.dao.IndexContentManageDao;
import com.hl.yt.manage.dto.IndexContentManageDTO;
@Service
public class IndexContentManageService {
	@Autowired
	IndexContentManageDao indexContentManageDao;

	public int save(String content) {
		return indexContentManageDao.save(content);
	}

	public int update(int id,String content) {
		return indexContentManageDao.update(id,content);
	}

	public IndexContentManageDTO getContent() {
		IndexContentManageDTO content = indexContentManageDao.getContent();
		return content;
	}
}
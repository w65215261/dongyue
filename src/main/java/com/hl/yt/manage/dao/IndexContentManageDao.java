package com.hl.yt.manage.dao;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.manage.dto.IndexContentManageDTO;

public interface IndexContentManageDao {

	int save(@Param("content") String content);

	int update(@Param("id") int id, @Param("content") String content);

	IndexContentManageDTO getContent();
}
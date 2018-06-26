package com.hl.yt.manage.dao;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.manage.dto.CallUsManageDTO;

public interface CallUsManageDao {
	int save(@Param("content") String content);

	int update(@Param("id") int id, @Param("content") String content);

	CallUsManageDTO getCallus();

}
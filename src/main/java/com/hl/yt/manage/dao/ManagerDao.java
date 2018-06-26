package com.hl.yt.manage.dao;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.manage.dto.ManagerDTO;

public interface ManagerDao {

	ManagerDTO getManager(@Param("username") String username, @Param("password") String password);
}

package com.hl.yt.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.manage.dto.AuthorizeManageDTO;

public interface AuthorizeManageDao {
	int save(@Param("name") String name, @Param("code") String code, @Param("wechatNumber") String wechatNumber,
			@Param("phoneNumber") String phoneNumber, @Param("address") String address,
			@Param("proxyLevel") int proxyLevel, @Param("startDate") String startDate, @Param("endDate") String endDate);

	int update(@Param("id") int id, @Param("name") String name,
			@Param("wechatNumber") String wechatNumber, @Param("phoneNumber") String phoneNumber,
			@Param("address") String address, @Param("proxyLevel") int proxyLevel, @Param("startDate") String startDate,
			@Param("endDate") String endDate);

	int del(int id);

	AuthorizeManageDTO getAuthorize(@Param("id") int id);

	List<AuthorizeManageDTO> getAuthorizes(@Param("start") int start, @Param("pageSize") int pageSize);
	
	List<AuthorizeManageDTO> getCodes();

	int getAuthorizeCount();

}
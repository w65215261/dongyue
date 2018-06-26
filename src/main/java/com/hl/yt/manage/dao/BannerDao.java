package com.hl.yt.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.manage.dto.BannerDTO;

public interface BannerDao {

	int save(@Param("title") String title, @Param("content") String content,
			@Param("banner") String banner, @Param("imgId") int imgId);

	List<BannerDTO> getBannerList();

	BannerDTO getBanner(int id);

	int del(int id);

	int update(@Param("id") int id, @Param("title") String title,
			@Param("content") String content, @Param("banner") String banner, @Param("imgId") int imgId);
}
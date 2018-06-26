package com.hl.yt.client.dao;

import org.apache.ibatis.annotations.Param;

import com.hl.yt.client.dto.AuthorizeDTO;

public interface AuthorizeDao {

	AuthorizeDTO getAuthorizes(@Param("parameter") String parameter);

}
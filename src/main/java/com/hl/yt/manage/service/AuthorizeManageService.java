package com.hl.yt.manage.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.yt.manage.dao.AuthorizeManageDao;
import com.hl.yt.manage.dto.AuthorizeManageDTO;

@Service
public class AuthorizeManageService {
	@Autowired
	AuthorizeManageDao authorizeDao;

	public int save(String name, String wechatNumber, String phoneNumber, String address, int proxyLevel,
			String startDate, String endDate) {
		String code = "";
		List<AuthorizeManageDTO> codes = authorizeDao.getCodes();
		List<Integer> c = new ArrayList<>();
		String yearLast = new SimpleDateFormat("yy",Locale.CHINESE).format(new Date());
		for(AuthorizeManageDTO amd:codes) {
			String codeStringAll = amd.getCode();
			String codeSubString = codeStringAll.substring(1);
			c.add(Integer.valueOf(codeSubString));
			Collections.sort(c);
		}
		if(codes.size()==0) {
			code = "D"+yearLast+"0000";
		}else {
			Integer codeMax = c.get(c.size()-1);
			Integer codeValue = codeMax + 1;
			code = "D" + yearLast + String.valueOf(codeValue).substring(2);
		}
		return authorizeDao.save(name, code, wechatNumber, phoneNumber, address, proxyLevel, startDate, endDate);
	}

	public int update(int id, String name, String wechatNumber, String phoneNumber, String address,
			int proxyLevel, String startDate, String endDate) {
		return authorizeDao.update(id, name, wechatNumber, phoneNumber, address, proxyLevel, startDate,
				endDate);
	}
	
	public List<AuthorizeManageDTO> getAuthorizes(int start, int pageSize) {
		return authorizeDao.getAuthorizes(start, pageSize);
	}

	public int getAuthorizeCount() {
		return authorizeDao.getAuthorizeCount();
	}

	public AuthorizeManageDTO getAuthorize(int id) {
		return authorizeDao.getAuthorize(id);
	}

	public int del(int id) {
		return authorizeDao.del(id);
	}
}
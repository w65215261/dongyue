package com.hl.yt.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Base {

	/**
	 * 添加新的session对象
	 * 
	 * @param name
	 * @param obj
	 */
	public void addSession(String name, Object obj) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
		request.getSession().setAttribute(name, obj);
		request.getSession().setMaxInactiveInterval(3600 * 1000);
	}

	/**
	 * 获取session
	 * 
	 * @param name
	 * @return
	 */
	public Object getSession(String name) {
		HttpServletRequest request = getRequest();
		Object obj = null;
		if (!"".equals(name.trim()))
			obj = request.getSession().getAttribute(name);
		return obj;
	}

	public void delSession() {
		HttpServletRequest request = getRequest();
		request.getSession().invalidate();
	}

	public HttpServletRequest getRequest() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
		return request;
	}

	public int page(int count, int pageSize) {
		int pageCount = 0;
		if ((float) count / (float) pageSize <= 1)
			pageCount = 1;
		else if (count % pageSize == 0)
			pageCount = count / pageSize;
		else if (count % pageSize > 0)
			pageCount = count / pageSize + 1;
		return pageCount;
	}
}
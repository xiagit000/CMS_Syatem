package com.boventech.cms.action.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyURLWrapper extends HttpServletRequestWrapper implements
		ServletRequest {

	private String newUri;
	
	private String newPath;
	
	public MyURLWrapper(HttpServletRequest request) {
		super(request);
		this.newUri = URLPatternEngine.getNewStr(super.getRequestURI());
		this.newPath = URLPatternEngine.getNewStr(super.getServletPath());
	}

	@Override
	public String getRequestURI() {
		String uri = super.getRequestURI();
		return URLPatternEngine.matches(uri) ? this.newUri : uri;
	}
	
	@Override
	public String getServletPath() {
		String path = super.getServletPath();
		return URLPatternEngine.matches(path) ? this.newPath : path;
	}
	
}

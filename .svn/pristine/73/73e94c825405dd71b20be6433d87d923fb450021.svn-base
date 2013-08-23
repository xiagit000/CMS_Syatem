package com.boventech.sr4j.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.boventech.sr4j.Matcher;
import com.boventech.sr4j.URLRewriteEngine;

public class MyURLWrapper extends HttpServletRequestWrapper {


	public MyURLWrapper(HttpServletRequest request, String uri, String path) {
		super(request);
		
	}

	
	@Override
	public String getServletPath() {
		Matcher m = URLRewriteEngine.getInstance().match(super.getServletPath());
		if(m.isMatch()) {
			return m.getMatchedURL();
			
		} else {
			return super.getServletPath();
		}
	}
	
}

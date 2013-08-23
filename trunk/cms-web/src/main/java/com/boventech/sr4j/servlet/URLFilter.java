package com.boventech.sr4j.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.boventech.sr4j.Matcher;
import com.boventech.sr4j.URLRewriteEngine;

public class URLFilter implements Filter{
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = ((HttpServletRequest)request); 
		String path = httpServletRequest.getServletPath();
		Matcher matcher = URLRewriteEngine.getInstance().match(path);
		if(matcher.isMatch()){
			httpServletRequest = new MyURLWrapper(httpServletRequest, matcher.getMatchedURL(), matcher.getMatchedURL());
			chain.doFilter(httpServletRequest, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
}

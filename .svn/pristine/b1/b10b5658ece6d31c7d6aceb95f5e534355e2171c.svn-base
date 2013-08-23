package com.boventech.cms.action.interceptor;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.FileUploadInterceptor;

import static com.boventech.cms.action.util.ApplicationConstants.*;

import com.opensymphony.xwork2.ActionInvocation;

public class UploadInterceptor extends FileUploadInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7674940818265032294L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Integer size = get(SYSTEM_ATTACHMENT_SIZE);
		Long allowSize = getAllowSize(size);
		if(allowSize != null){
			super.setMaximumSize(allowSize);
		}
		String allowedTypes = get(SYSTEM_ATTACHMENT_TYPE);
		if(allowedTypes != null && allowedTypes.trim().length() > 0){
			super.setAllowedTypes(allowedTypes);
		}
		String allowedExtensions = get(SYSTEM_ATTACHMENT_EXTENSION);
		if(allowedExtensions != null && allowedExtensions.trim().length() > 0){
			super.setAllowedExtensions(allowedExtensions);
		}
		return super.intercept(invocation);
	}
	
	private Long getAllowSize(Integer size){
		if(size != null){
			long maxSize = 1024 * 1024 * size;
			return Long.valueOf(maxSize);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private<T> T get(final String key){
		ServletContext context = ServletActionContext.getServletContext();
		return (T) context.getAttribute(key);
	}
	
}

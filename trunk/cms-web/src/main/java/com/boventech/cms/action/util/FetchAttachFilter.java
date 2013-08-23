package com.boventech.cms.action.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.boventech.cms.module.download.Attachment;
import com.boventech.cms.module.user.User;
import com.boventech.cms.service.download.AttachmentService;
import com.boventech.cms.service.user.UserService;
import com.boventech.util.action.ActionConstants;

public class FetchAttachFilter implements Filter{

	private static final String UPLOAD = "/upload/file";
	
	private AttachmentService attachmentService;
	
	private UserService userService;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = ((HttpServletRequest)request);
		HttpServletResponse resp = ((HttpServletResponse)response);
		String uri = req.getRequestURI();
		if(uri.contains(UPLOAD)){
			String filePath = getFilePath(uri);
			Attachment attach = attachmentService.findByFilePath(filePath);
			User user = null;
			Integer userId = (Integer) req.getSession().getAttribute(ActionConstants.CURRENT_USER_ID);
			if(userId != null){
				user = userService.findById(userId);
			}
			//if(attach != null && attach.canBeAccessBy(user))
//		    if(user != null)
				chain.doFilter(request, response);
//			else
//				resp.sendError(404);
		}
	}

	private String getFilePath(String uri) {
		int index = uri.indexOf(UPLOAD);
		return uri.substring(index);
	}

	public void init(FilterConfig config) throws ServletException {
		ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		attachmentService = (AttachmentService) context.getBean("attachmentService");
		userService = (UserService) context.getBean("userService");
	}

}

package com.boventech.cms.action.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.boventech.cms.module.system.SystemInfo;
import com.boventech.cms.permalink.NewsPermalinkDefinition;
import com.boventech.cms.service.node.MenuService;
import com.boventech.cms.service.system.SystemInfoService;
import com.boventech.permalink.PermalinkManager;
import com.boventech.sr4j.URLRewriteEngine;

public class ApplicationListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		
		ApplicationUtils.destroyMenus(context);
		
		ApplicationUtils.destroySystemInfo(context);
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		ApplicationContext applicationContext = (ApplicationContext) context.getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		MenuService menuService = getBean(applicationContext,"menuService");
		ApplicationUtils.initMenus(context, menuService);
		
		SystemInfoService systemInfoService = getBean(applicationContext,"systemInfoService");
		if(systemInfoService.loadSystemInfo() == null){
			SystemInfo si = new SystemInfo();
			systemInfoService.updateSystemInfo(si);			
		}
		ApplicationUtils.initSystemInfo(context, systemInfoService);			
		
		
		String systemUrlPattern = (String)sce.getServletContext().getAttribute(ApplicationConstants.SYSTEM_URL_PATTERN);
		
		if(systemUrlPattern == null){
			systemUrlPattern = "/news/%{news_year}-%{news_month}-%{news_day}/%{news_id}.shtml";
		}
		
		URLRewriteEngine.getInstance().addRule("/", "/open");
		
		NewsPermalinkDefinition d = new NewsPermalinkDefinition(systemUrlPattern);		
		URLRewriteEngine.getInstance().addRule(d.definitionReguarExpression(), "/open/entry/$1");
		
		PermalinkManager.getInstance().setAutoRegisterRewriteRule(false);
		PermalinkManager.getInstance().register(d);
		
		
	}
	
	@SuppressWarnings("unchecked")
	private<T> T getBean(ApplicationContext context, String beanName){
		return (T) context.getBean(beanName);
	}

}

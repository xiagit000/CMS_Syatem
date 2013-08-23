package com.boventech.cms.action.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LDAPEngineListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		LDAPEngine.stop();
	}

	public void contextInitialized(ServletContextEvent sce) {
//		ServletContext context = sce.getServletContext();
//		ApplicationContext applicationContext = (ApplicationContext) context.getAttribute(
//				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//		LdapSettingService ldapSettingService = (LdapSettingService) applicationContext
//			.getBean("ldapSettingService");
//		LdapSetting ldapSetting = ldapSettingService.getSetting();
//		LDAPEngine.start(ldapSetting);
	}

}

package com.boventech.cms.action.util;

import static com.boventech.cms.action.util.ApplicationConstants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.boventech.cms.module.node.Menu;
import com.boventech.cms.module.system.SystemInfo;
import com.boventech.cms.service.node.MenuService;
import com.boventech.cms.service.system.SystemInfoService;

public class ApplicationUtils {

	/**
	 * initialize menus
	 * @param context
	 * @param menuService
	 */
	public static void initMenus(ServletContext context, MenuService menuService){
		generateMenus(context, menuService);
	}
	
	/**
	 * destroy menus
	 * @param context
	 */
	public static void destroyMenus(ServletContext context){
		context.removeAttribute(OPEN_MENUS);
		context.removeAttribute(ADMIN_MENUS);
		context.removeAttribute(OPEN_MENUS_MAP);
		context.removeAttribute(ADMIN_MENUS_MAP);
	}
	
	/**
	 * update menus
	 * @param context
	 * @param menuService
	 */
	public static void updateMenus(ServletContext context, MenuService menuService){
		generateMenus(context, menuService);
	}
	
	private static void generateMenus(ServletContext context,
			MenuService menuService) {
		List<Menu> openMenus = menuService.listOpenMenus();
		List<Menu> adminMenus = menuService.listAdminMenus();
		context.setAttribute(OPEN_MENUS, openMenus);
		context.setAttribute(ADMIN_MENUS, adminMenus);
		context.setAttribute(OPEN_MENUS_MAP, createMenuMap(openMenus));
		context.setAttribute(ADMIN_MENUS_MAP, createMenuMap(adminMenus));
	}

	private static Map<Integer, Menu> createMenuMap(List<Menu> menus){
		Map<Integer, Menu> map = new HashMap<Integer, Menu>();
		for(Menu menu:menus){
			if(menu != null){
				map.put(menu.getNodeId(), menu);
				if(menu.getChildren().size() > 0){
					map.putAll(createMenuMap(menu.getChildren()));
				}
			}
		}
		return map;
	}

	public static void initSystemInfo(ServletContext context,
			SystemInfoService systemInfoService) {
		SystemInfo info = systemInfoService.loadSystemInfo();
		setSystemInfo(context, info);
	}

	public static void destroySystemInfo(ServletContext context) {
		context.removeAttribute(SYSTEM_INFO);
		context.removeAttribute(SYSTEM_NAME);
		context.removeAttribute(SYSTEM_KEYWORDS);
		context.removeAttribute(SYSTEM_COPYRIGHT);
		context.removeAttribute(SYSTEM_HOSTNAME);
		context.removeAttribute(SYSTEM_HIGHLIGHT);
		context.removeAttribute(SYSTEM_HIGHLIGHT_DAYS);
		context.removeAttribute(SYSTEM_ALLOW_ATTACHMENT);
		context.removeAttribute(SYSTEM_ATTACHMENT_SIZE);
		context.removeAttribute(SYSTEM_ALLOW_COMMENT);
		context.removeAttribute(SYSTEM_ALLOW_LDAP);
		context.removeAttribute(SYSTEM_URL_PATTERN);
		context.removeAttribute(SYSTEM_ATTACHMENT_TYPE);
		context.removeAttribute(SYSTEM_ATTACHMENT_EXTENSION);
	}

	public static void updateSystemInfo(ServletContext context, SystemInfo info) {
		setSystemInfo(context, info);
	}

	private static void setSystemInfo(ServletContext context, SystemInfo info) {
//		context.setAttribute(SYSTEM_INFO, info);
		context.setAttribute(SYSTEM_NAME, info.getBaseInfo().getSystemName());
		context.setAttribute(SYSTEM_KEYWORDS, info.getBaseInfo().getKeyWord());
		context.setAttribute(SYSTEM_DESCRIPTION, info.getBaseInfo().getDescription());
//		context.setAttribute(SYSTEM_COPYRIGHT, info.getBaseInfo().getCopyRight());
//		context.setAttribute(SYSTEM_HOSTNAME, info.getBaseInfo().getHostName());
//		context.setAttribute(SYSTEM_HIGHLIGHT, info.getHighlightInfo().getHighlight());
//		context.setAttribute(SYSTEM_HIGHLIGHT_DAYS, info.getHighlightInfo().getHighlightDays());
//		context.setAttribute(SYSTEM_ALLOW_ATTACHMENT, info.getAttachmentInfo().getAllowAttachment());
//		context.setAttribute(SYSTEM_ATTACHMENT_SIZE, info.getAttachmentInfo().getAttachmentSize());
		context.setAttribute(SYSTEM_ALLOW_COMMENT, info.isAllowComment());
//		context.setAttribute(SYSTEM_ALLOW_LDAP, info.isAllowLDAP());
//		context.setAttribute(SYSTEM_URL_PATTERN, info.getUrlPattern());
		context.setAttribute(SYSTEM_URL_PATTERN, "/news/%{news_year}-%{news_month}-%{news_day}/%{news_id}.shtml");
		
//		context.setAttribute(SYSTEM_ATTACHMENT_TYPE, info.getAttachmentInfo().getAttachmentType());
//		context.setAttribute(SYSTEM_ATTACHMENT_EXTENSION, info.getAttachmentInfo()
//				.getAttachmentExtension());
	}
	
	/**
	 * 
	 * @param <T>	the type of result you want
	 * @param key	the key of the application attribute.
	 * @return		the value corresponding the key 
	 */
	@SuppressWarnings("unchecked")
	public static<T> T get(String key){
		return (T)ServletActionContext.getServletContext().getAttribute(key);
	}
}

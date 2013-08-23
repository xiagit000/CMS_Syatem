package com.boventech.cms.action.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public final class URLPatternEngine implements ServletContextListener{
	
	private static final String URL_CONTENT= "/open/entry/";
	
	private static String systemUrlPattern;
	
	private static String urlPattern;

	private static final Map<String, String> URL_PATTERN_MAP =
		new HashMap<String, String>();
	
	private static final Map<String, String> URL_BLACKLIST_MAP =
		new HashMap<String, String>();
	
	static{
		URL_PATTERN_MAP.put("%{news_year}", "\\d{4}");
		URL_PATTERN_MAP.put("%{news_month}", "\\d{2}");
		URL_PATTERN_MAP.put("%{news_day}", "\\d{2}");
		URL_PATTERN_MAP.put("%{news_id}", "(\\d+)");
	}
	
	static{
		URL_BLACKLIST_MAP.put("/", "/open");
		URL_BLACKLIST_MAP.put("/index.jsp", "/open");
		URL_BLACKLIST_MAP.put("/index.html", "/open");
	}
	
	private static boolean isOnBlackist(String key){
		return URL_BLACKLIST_MAP.containsKey(key);
	}
	
	/**
	 * get the new string through the given pattern.
	 * @param oldStr	old string
	 * @return	new string
	 */
	public static String getNewStr(String oldStr){
		if(isOnBlackist(oldStr))
			return URL_BLACKLIST_MAP.get(oldStr);
		String str = oldStr;
		Pattern pattern = Pattern.compile(urlPattern);
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			String res = matcher.group(1);
			str = URL_CONTENT+res;
		}
		return str;
	}
	
	private static String generateUrlPattern() {
		String temp = systemUrlPattern;
		Set<Entry<String, String>> set = URL_PATTERN_MAP.entrySet();
		for(Entry<String, String> e:set){
			temp = temp.replace(e.getKey(), e.getValue());
		}
		return temp;
	}
	
	public static boolean matches(String str){
		if(isOnBlackist(str))
			return true;
		Pattern pattern = Pattern.compile(urlPattern);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	public static String getEntryUrl(com.boventech.cms.module.node.Entry entry){
		Map<String, String> map = new HashMap<String, String>();
		initOutputMap(entry, map);
		String temp = systemUrlPattern;
		Set<Entry<String, String>> set = map.entrySet();
		for(Entry<String, String> e:set){
			temp = temp.replace(e.getKey(), e.getValue());
		}
		return temp;
	}

	private static void initOutputMap(
			com.boventech.cms.module.node.Entry entry, Map<String, String> map) {
		Date date = entry.getPublishedDate();
		map.put("%{news_year}", getDateString("yyyy", date));
		map.put("%{news_month}", getDateString("MM", date));
		map.put("%{news_day}", getDateString("dd", date));
		map.put("%{news_id}", String.valueOf(entry.getId()));
	}

	private static String getDateString(String pattern, Date date){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		systemUrlPattern = (String)sce.getServletContext()
			.getAttribute(ApplicationConstants.SYSTEM_URL_PATTERN);
		urlPattern = generateUrlPattern();
	}
	
	public static String getUrlPattern() {
		return urlPattern;
	}
	
	public static String getUrlContent() {
		return URL_CONTENT;
	}
	
	/**
	 * restart the URL pattern engine
	 * @param context
	 */
	public static void restart(ServletContext context){
		systemUrlPattern = (String)context
			.getAttribute(ApplicationConstants.SYSTEM_URL_PATTERN);
		urlPattern = generateUrlPattern();
	}
}

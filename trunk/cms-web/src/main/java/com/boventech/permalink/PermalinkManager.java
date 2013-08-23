package com.boventech.permalink;

import java.util.HashMap;
import java.util.Map;

public class PermalinkManager {

	private static PermalinkManager manager = new PermalinkManager();

	private Map<Class<?>, PermalinkDefinition> definitioins = 
		new HashMap<Class<?>, PermalinkDefinition>();

	private boolean autoSetRewriteRule;

	public static PermalinkManager getInstance() {
		return manager;
	}

	public void register(PermalinkDefinition definition) {
		this.definitioins.put(definition.getType(), definition);
		if(this.autoSetRewriteRule) {
			
		}
	}

	public String generatePermalink(Object obj) {
		Class<?> type = obj.getClass();
		PermalinkDefinition df = definitioins.get(type);
		if(df!= null) {
			return df.generatePermalink(obj);
		}
		throw new RuntimeException("could not find permalink definition for type :" + type);
		
	}

	public void setAutoRegisterRewriteRule(boolean autoSetRewriteRule) {
		this.autoSetRewriteRule = autoSetRewriteRule;
	}

}

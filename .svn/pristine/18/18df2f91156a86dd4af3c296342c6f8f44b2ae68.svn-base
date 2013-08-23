package com.boventech.cms.permalink;

import com.boventech.cms.module.node.Entry;
import com.boventech.permalink.GenericPermalinkDefinition;
import com.boventech.permalink.PermalinkVariable;

public class NewsPermalinkDefinition extends GenericPermalinkDefinition{
	
	
	private static final String NEWS_ACTION = "/open/entry/%{news_id}";
	
	public NewsPermalinkDefinition(String newsPermalink) {
		this(Entry.class, newsPermalink, NEWS_ACTION);
	}
	
	
	public NewsPermalinkDefinition(Class<?> type, String definition, String string2) {
		super(type, definition, string2);
	}

	@Override
	public PermalinkVariable[] supportedVariables() {
		return NewsPermalinkVariable.values();
	}
	
}

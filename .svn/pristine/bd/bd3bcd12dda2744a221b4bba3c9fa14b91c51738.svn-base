package com.boventech.permalink.entity;

import com.boventech.permalink.GenericPermalinkDefinition;
import com.boventech.permalink.PermalinkVariable;

public class NewsPermalinkDefinition extends GenericPermalinkDefinition {

    public NewsPermalinkDefinition() {
        this(News.class, "/news/%{news_year}/%{news_id}.html", "/news.do?id=%{news_id}");
    }

    public NewsPermalinkDefinition(Class<?> type, String definition, String string2) {
        super(type, definition, string2);
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public PermalinkVariable[] supportedVariables() {
        return NewsPermalinkVariable.values();
    }

}

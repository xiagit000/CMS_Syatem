package com.boventech.permalink;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.boventech.permalink.entity.News;
import com.boventech.permalink.entity.NewsPermalinkDefinition;
import com.boventech.sr4j.Matcher;
import com.boventech.sr4j.URLRewriteEngine;

public class PermalinkManagerTest {

	PermalinkManager manager ;
	
	@Before
	public void setUp() throws Exception {
		manager = PermalinkManager.getInstance();
		manager.setAutoRegisterRewriteRule(false);
		GenericPermalinkDefinition definition = new NewsPermalinkDefinition();
		manager.register(definition);
		URLRewriteEngine.getInstance().addRule( definition.definitionReguarExpression(), "/news.do?id=$2");
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testGenerate() {
		News n = new News(2010, 123L);

		String url = manager.generatePermalink(n);
		assertEquals("/news/2010/123.html", url);
		
		n = new News(2011, 112L);
		url = manager.generatePermalink(n);
		assertEquals("/news/2011/112.html", url);
		
	}

	@Test
	public void testURLRewrite() {
		Matcher matcher = URLRewriteEngine.getInstance().match("/news/2011/112.html");
		assertTrue(matcher.isMatch());
		assertEquals("/news.do?id=112", matcher.getMatchedURL());
	}
	
}



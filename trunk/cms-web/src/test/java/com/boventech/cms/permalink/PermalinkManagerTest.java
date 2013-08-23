package com.boventech.cms.permalink;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.boventech.cms.module.node.Entry;
import com.boventech.permalink.GenericPermalinkDefinition;
import com.boventech.permalink.PermalinkManager;
import com.boventech.sr4j.Matcher;
import com.boventech.sr4j.URLRewriteEngine;

public class PermalinkManagerTest {

	PermalinkManager manager ;
	
	@Before
	public void setUp() throws Exception {
		manager = PermalinkManager.getInstance();
		manager.setAutoRegisterRewriteRule(false);
		GenericPermalinkDefinition definition = new NewsPermalinkDefinition("/news/%{news_id}.shtml");
		manager.register(definition);
		URLRewriteEngine.getInstance().addRule( definition.definitionReguarExpression(), "/open/entry/$1");
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testGenerate() {
		Entry e = new Entry();
		e.setId(1234);
		e.setPublishedDate(new Date());

		String url = manager.generatePermalink(e);
		assertEquals("/news/1234.shtml", url);
		
	
		
	}

	@Test
	public void testURLRewrite() {
		Matcher matcher = URLRewriteEngine.getInstance().match("/news/112.shtml");
		assertTrue(matcher.isMatch());
		assertEquals("/open/entry/112", matcher.getMatchedURL());
	}
	
}



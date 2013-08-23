package com.boventech.permalink;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boventech.permalink.entity.News;
import com.boventech.permalink.entity.NewsPermalinkDefinition;

public class PermalinkDefinitionTest {

	
	@Test
	public void testGenerate() {
		News n = new News(2010, 123L);
		GenericPermalinkDefinition definition = new NewsPermalinkDefinition();
		
		String url = definition.generatePermalink(n);
		assertEquals("/news/2010/123.html", url);
		
		n = new News(2011, 112L);
		url = definition.generatePermalink(n);
		assertEquals("/news/2011/112.html", url);
		
	}

	
}



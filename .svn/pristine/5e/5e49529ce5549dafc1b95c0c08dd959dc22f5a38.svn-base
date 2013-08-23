package com.boventech.sr4j;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RewriteRuleTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	
	@Test
	public void testDynamicRule() {
		
		URLRewriteRule rule = new URLRewriteRule("/open", "/");

		rule = new URLRewriteRule("/users/(\\w+)", "/users?id=$1");
		matchAssert(rule, true, "/users/1234", "/users?id=1234");
		
		rule = new URLRewriteRule("/users/(\\w+)/profile/(\\w+)", "/profile?uid=$1&pid=$2");
		matchAssert(rule, true, "/users/1234/profile/6789", "/profile?uid=1234&pid=6789");
		
	}
	
	@Test
	public void testStaticRule() {
		
		URLRewriteRule rule = new URLRewriteRule("/open", "/");

		matchAssert(rule, true, "/open", "/");
		
		rule = new URLRewriteRule("/zdxw", "/node?id=1");
		matchAssert(rule, true, "/zdxw", "/node?id=1");
		matchAssert(rule, false, "/zsxw", "/zsxw");

		rule = new URLRewriteRule("/xyxw", "/node?id=2");
		matchAssert(rule, true, "/xyxw", "/node?id=2");

	}
	
	private void matchAssert(URLRewriteRule rule, boolean b, String from, String to) {
		
		Matcher matcher = rule.match(from);
		assertEquals(b, matcher.isMatch());
		assertEquals(to,matcher.getMatchedURL());
	}

}

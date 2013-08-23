package com.boventech.sr4j;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RewriteEngineTest {

	@Before
	public void setUp() throws Exception {
		URLRewriteEngine engine = URLRewriteEngine.getInstance();
		engine.addRule("/open", "/");
		engine.addRule("/zdxw", "/node?id=1");
		engine.addRule("/xyxw", "/node?id=2");
		
		engine.addRule("/users/(\\w+)", "/users?id=$1");
		engine.addRule("/users/(\\w+)/profile/(\\w+)", "/profile?uid=$1&pid=$2");
		engine.addRule("/customers/(\\w+)", "/customerAction?id=$1");
	}

	@After
	public void tearDown() throws Exception {
		URLRewriteEngine.getInstance().clearRules();
	}
	
	
	@Test
	public void testDynamicRule() {
		
		matchAssert(true, "/users/1234", "/users?id=1234");
		
		matchAssert(true, "/users/1234/profile/6789", "/profile?uid=1234&pid=6789");
		
		matchAssert(true, "/customers/12345", "/customerAction?id=12345");
		
	}
	
	@Test
	public void testStaticRule() {

		matchAssert(true, "/open", "/");
		
		matchAssert(true, "/zdxw", "/node?id=1");
		
		matchAssert(true, "/xyxw", "/node?id=2");
		
	}
	
	private void matchAssert(boolean b, String from, String to) {
		URLRewriteEngine engine = URLRewriteEngine.getInstance();
		Matcher matcher = engine.match(from);
		assertEquals(b, matcher.isMatch());
		assertEquals(to,matcher.getMatchedURL());
	}

}

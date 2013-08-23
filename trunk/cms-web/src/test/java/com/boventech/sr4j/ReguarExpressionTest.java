package com.boventech.sr4j;


import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReguarExpressionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Pattern p = Pattern.compile("/users/(\\w+)/profile/(\\w+)");
		java.util.regex.Matcher m = p.matcher("/users/12312/profile/2324");
		assertTrue(m.matches());
		int count = m.groupCount();
		assertEquals(2, count);
		assertEquals("12312", m.group(1));
		assertEquals("2324", m.group(2));
	}
	
}

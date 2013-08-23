package com.boventech.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class IndexPageTest {

    private Selenium selenium;
    private static SeleniumServer server;
    
    @BeforeClass
    public static void before() throws Exception {
        server = new SeleniumServer();
        server.start();
    }
    
    @AfterClass
    public static void after() {
        server.stop();
    }

    @Before
    public void setUp() throws Exception {
        String url = "http://localhost:8080";
        selenium = new DefaultSelenium("localhost", 4444, "*googlechrome", url);
        selenium.start();
    }

    @After
    public void tearDown() throws Exception {
        this.selenium.stop();
    }

    @Test
    public void testOpenIndex() {
        this.selenium.open("/");
        assertTrue(this.selenium.isTextPresent("学院介绍"));
    }

    @Test
    public void testLoginSuccess() {
        this.selenium.open("/");
        this.selenium.type("//input[@name='username']", "admin");
        this.selenium.type("//input[@name='password']", "123456");
        this.selenium.click("//button[@class='btn1']");
        this.selenium.waitForPageToLoad("30000");
        assertTrue(this.selenium.isTextPresent("后台管理"));
        assertFalse(this.selenium.isTextPresent("用户名"));
    }    

    @Test
    public void testLoginFailed() {
        this.selenium.open("/");
        this.selenium.type("//input[@name='username']", "admin");
        this.selenium.type("//input[@name='password']", "1234567");
        this.selenium.click("//button[@class='btn1']");
        this.selenium.waitForPageToLoad("30000");
        assertTrue(this.selenium.isTextPresent("用户名"));
        assertFalse(this.selenium.isTextPresent("后台管理"));
    }    
    
    
}

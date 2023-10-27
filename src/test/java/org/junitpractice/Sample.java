package org.junitpractice;

import java.io.File;
import java.io.IOException;

import org.baseclass.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import org.pages.LoginPage;

public class Sample extends BaseClass{
	static WebElement userName;
	static WebElement password;
	@BeforeClass
	public static void beforeClass() {}
	
//	@Before
//	public void before() {
//		
//	}
	
	@Test
	public void fb() {	
		passValue(userName, "Vel");
		passValue(password, "999");
		
	}
	
	@Test
	public void dd() {
		passValue(userName, "Saba");
		passValue(password, "999");
	}
	
	@Test
	public void aa() {
		Assert.assertTrue(false);
		passValue(userName, "Sathish");
		passValue(password, "999");
	}
	
	@After
	public void after() throws IOException, InterruptedException {
		Thread.sleep(3000);
		screenshot(new File("C:\\Users\\Lenovo\\eclipse-workspace"
				+ "\\MavenSepAdv\\target\\ss.png"));
		refreshPage();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public static void afterClass() {	
		quitBrowser();
	}
	
	
	
	
}

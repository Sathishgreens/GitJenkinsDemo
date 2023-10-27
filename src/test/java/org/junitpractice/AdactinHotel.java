package org.junitpractice;

import java.io.File;
import java.io.IOException;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pages.LoginPage;
import org.pages.PageManager;
import org.pages.SearchHotelPage;

public class AdactinHotel extends BaseClass{
	static PageManager manager;
	@BeforeClass
	public static void initialSet() {
		browserLaunch("chrome");		
		maximize();
		loadUrl("https://adactinhotelapp.com/");
		manager = new PageManager();
	}
	
	@Test
	public void tc1() {
		LoginPage loginPage = manager.getLoginPage();
		passValue(loginPage.getUserName(), "sathishgreens123");
		passValue(loginPage.getPassword(), "Greens@123");
		elementClick(loginPage.getLoginButton());
		WebElement pageText = findingElement("id", "username_show");
		String atributeValue = getAtributeValue(pageText, "value");
		Assert.assertEquals("Landed in Wrong Profile","Heo sathishgreens123!", atributeValue);
		//Assert.assertTrue(pageText.isDisplayed());
		
		System.out.println("Assert Passed");
	}
	
	
	@Test(timeout=1000)
	public void tc2() throws InterruptedException, IOException {
		//Thread.sleep(3000);
		SearchHotelPage searchHotelPage = manager.getSearchHotelPage();
		dropDown(searchHotelPage.getLocation(), "value", "Sydney");
		dropDown(searchHotelPage.getHotel(), "text", "Hotel Sunshine");
		dropDown(searchHotelPage.getRoomType(), "text", "Double");
		dropDown(searchHotelPage.getNoOfRooms(), "index", "2");		
	}
	
	
	

}

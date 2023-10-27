package org.testngpractice;

import org.baseclass.BaseClass;
import org.pages.PageManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

public class TestScenario1 extends BaseClass {
	@Test
	private void tc1_1() {

		browserLaunch("chrome");
		loadUrl("https://github.com/login");

	}
	@Test
	private void tc1_2() {

		browserLaunch("chrome");
		loadUrl("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.5.3");

	}

}

package org.testngpractice;

import org.baseclass.BaseClass;
import org.pages.PageManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScenario2 extends BaseClass{
	@Test
	private void tc2_1() {

		browserLaunch("edge");
		loadUrl("https://github.com/login");
		//Assert.assertTrue(false);
	}
	
	
}

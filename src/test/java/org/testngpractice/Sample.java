package org.testngpractice;

import java.io.File;
import java.io.IOException;
import org.baseclass.BaseClass;
import org.fbpages.FBLoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sample extends BaseClass {
	
	@Test
	private void tcs_1() {

		browserLaunch("firefox");
		Reporter.log("GitHub is to be launched");
		loadUrl("https://github.com/login");

	}
	
}

package org.testngpractice;


import org.baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampeTest extends BaseClass {
	
	@Test(retryAnalyzer = FailureRerun.class)
	private void tc1_1() {

		browserLaunch("chrome");
		loadUrl("https://www.facebook.com/");
		//Assert.assertTrue(false);
	}
	
	@Test
	private void tc1_2() {

		browserLaunch("edge");
		loadUrl("https://www.facebook.com/");
		Assert.assertTrue(false);
	}
	
	
}

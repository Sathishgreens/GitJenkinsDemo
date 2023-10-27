package org.testngpractice;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomReporter implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started");
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Succesfully Comleted");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed");
	}

}

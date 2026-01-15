package com.flipkart.qa.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.flipkart.qa.utils.Reporters;
import com.flipkart.qa.utils.Utilities;

public class MyListeners implements ITestListener, ISuiteListener{
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ISuite suite) {
		
		extentReport = Reporters.generateExtentReport();
		
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println(context.getName()+" Started");
		
	}

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+" Started Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, result.getName()+" got passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());			
			
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	    
	    String destScreenshotPath = Utilities.takeScreenshot(driver, result.getName());
	    
	    extentTest.addScreenCaptureFromPath(destScreenshotPath);
	    extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+" got Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got Skipped");

	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println(context.getName()+" Finished");
		
	}
	
	@Override
	public void onFinish(ISuite suite) {
		extentReport.flush();
	}

}

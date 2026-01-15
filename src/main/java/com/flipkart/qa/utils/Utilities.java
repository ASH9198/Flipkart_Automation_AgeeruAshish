package com.flipkart.qa.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 5;
	public static final int PAGE_LOAD_TIME = 5;
	
	public static String takeScreenshot(WebDriver driver, String testMethodName) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir")+"\\Screenshots\\"+testMethodName+".png";
	    File destFile = new File(destPath);
	    try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return destPath;
	}

}

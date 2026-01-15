package com.flipkart.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporters {
	
	public static ExtentReports generateExtentReport() {
		
		Properties configProp;
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Flipkart End To End Automation Results");
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		try {
		    FileInputStream fis = new FileInputStream(configPropFile);
		    configProp.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		
		return extentReport;
	}

}

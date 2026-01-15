package com.flipkart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.flipkart.qa.utils.Utilities;

public class BasePage {
	
	WebDriver driver;
	public Properties configProperties;
	public static Properties testdataProperties;
	
	public BasePage() {
		configProperties = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		try {
		    FileInputStream fis = new FileInputStream(configPropFile);
		    configProperties.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		testdataProperties = new Properties();
		File testdataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipkart\\qa\\testdata\\testdata.properties");
		try {
			FileInputStream fis = new FileInputStream(testdataPropFile);
			testdataProperties.load(fis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--inprivate");
			driver = new EdgeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("-private");
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(configProperties.getProperty("url"));
		return driver;

	}

}

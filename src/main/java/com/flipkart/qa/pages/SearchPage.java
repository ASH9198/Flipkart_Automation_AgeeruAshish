package com.flipkart.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "//div[contains(.,'Brand')]/ancestor::section//div[@title='Apple']//div[contains(text(),'Apple')]")
	private WebElement applyBrandCheckBox;
	
	@FindBy(how = How.XPATH, xpath = "(//div[contains(text(),'Apple iPhone')])[1]")
	private WebElement iPhoneLink;
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void applyFilterOnBrand() {
		applyBrandCheckBox.click();
	}
	
	public void selectFirstAppearedPhone() {
		iPhoneLink.click();
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }
	}
	
	public void selectTheAppearedProduct() {
		applyFilterOnBrand();
		selectFirstAppearedPhone();
	}

}

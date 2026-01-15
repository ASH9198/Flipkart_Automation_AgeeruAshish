package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Login')]/ancestor::div/preceding-sibling::span[@role='button']")
	private WebElement loginPopUpCloseIcon;
	
	@FindBy(how = How.XPATH, xpath = "//input[@placeholder='Search for Products, Brands and More']")
	private WebElement searchInputTextBox;
	
	@FindBy(how = How.XPATH, xpath = "//button[@type='submit' and contains(@title,'Search for Products')]")
	private WebElement searchIcon;
	
	
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	public void closeLoginPopUpIfAppear() {
		try {
			boolean isLoginPopUpDisplayed = loginPopUpCloseIcon.isDisplayed();
			if(isLoginPopUpDisplayed) {
				loginPopUpCloseIcon.click();
			}
		} catch (Exception e) {
			System.out.println("No Login Popup appeared");
		}
	}
	
	public void searchProduct(String productName) {
		searchInputTextBox.sendKeys(productName);
		searchIcon.click();
	}
	
	public void searchAnIPhoneProduct(String productName) {
		closeLoginPopUpIfAppear();
		searchProduct(productName);
	}

}

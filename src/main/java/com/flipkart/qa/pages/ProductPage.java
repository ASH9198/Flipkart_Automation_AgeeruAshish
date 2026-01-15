package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Apple iPhone')]")
	private WebElement iPhoneProductName;
	
	@FindBy(how = How.XPATH, xpath = "(//span[contains(text(),'Apple iPhone')]/ancestor::div/following-sibling::div//div[contains(text(),'₹')])[1]")
	private WebElement iPhoneProductPrice;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void productName() throws InterruptedException {
		Thread.sleep(2000);
		String productFullName = iPhoneProductName.getText();
		System.out.println("iPhone Product Name"+productFullName);
	}
	
	public void productPrice() {
		String productPrice = iPhoneProductName.getText();
		System.out.println(productPrice);
	}
	
	public void productDetails() throws InterruptedException {
		productName();
		productPrice();
	}

}

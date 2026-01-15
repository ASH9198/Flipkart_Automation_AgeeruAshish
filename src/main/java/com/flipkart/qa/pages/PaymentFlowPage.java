package com.flipkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentFlowPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "//span[normalize-space()='Enter Email/Mobile number']/parent::label/preceding-sibling::input")
	private WebElement mobileEmailInputField;
	
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'CONTINUE')]/parent::button")
	private WebElement continueButton;
	
	public PaymentFlowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileOrEmail(String mobileNumber) throws InterruptedException {
		Thread.sleep(2000);
		mobileEmailInputField.sendKeys(mobileNumber);
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void completePaymentFlow(String mobileNumber) throws InterruptedException {
		enterMobileOrEmail(mobileNumber);
		clickOnContinue();
	}
	
	public boolean validateVerificationMessage(String mobileNumber) throws InterruptedException {
		String verificationMessage = "//div[contains(text(),'Verification code sent to "+mobileNumber+"')]";
		Thread.sleep(2000);
		boolean isMessageDisplayed = driver.findElement(By.xpath(verificationMessage)).isDisplayed();
		return isMessageDisplayed;
	}

}

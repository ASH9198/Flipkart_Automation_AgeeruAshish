package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, xpath = "//button[contains(normalize-space(),'Add to cart')]")
	private WebElement addToCartButton;
	
	@FindBy(how = How.XPATH, xpath = "//a[contains(text(),'Apple iPhone 17')]")
	private WebElement productDetailsInCart;
	
	@FindBy(how = How.XPATH, xpath = "//span[contains(text(),'Place Order')]")
	private WebElement placeOrderButton;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddToCart() {
		addToCartButton.click();
	}

	public boolean viewProductInCart() {
		boolean isProductAddedToCart = productDetailsInCart.isDisplayed();
		return isProductAddedToCart;
	}
	
	public void placeOrder() {
		placeOrderButton.click();
	}
	
	public boolean addProductToCartAndPlaceOrder() {
		clickOnAddToCart();
		boolean isProductPresent= viewProductInCart();
		placeOrder();
		return isProductPresent;
	}
}

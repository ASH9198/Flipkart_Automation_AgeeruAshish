package com.flipkart.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flipkart.qa.base.BasePage;
import com.flipkart.qa.pages.CartPage;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.PaymentFlowPage;
import com.flipkart.qa.pages.ProductPage;
import com.flipkart.qa.pages.SearchPage;

public class FlipkartEndToEndFlow extends BasePage{
	
	public FlipkartEndToEndFlow() {
		super();
	}
	
	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	ProductPage productPage;
	CartPage cartPage;
	PaymentFlowPage paymentFlowPage;
	
	@BeforeTest
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(configProperties.getProperty("browser"));
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		paymentFlowPage = new PaymentFlowPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test(description = "Product Selection")
	public void productSelection() throws InterruptedException {
		homePage.searchAnIPhoneProduct(testdataProperties.getProperty("ProductName"));
		searchPage.selectTheAppearedProduct();
		productPage.productDetails();
	}
	
	@Test(dependsOnMethods = "productSelection",description = "Add to Cart and Checkout")
	public void addToCartAndCheckout() {
		boolean isProductAddedToCartSuccessfully = cartPage.addProductToCartAndPlaceOrder();
		assertEquals(isProductAddedToCartSuccessfully, true);
	}
	
	@Test(dependsOnMethods = {"addToCartAndCheckout"}, description = "Login and Paymentflow")
	public void paymentFlow() throws InterruptedException {
		paymentFlowPage.completePaymentFlow(testdataProperties.getProperty("MobileNumber"));
		boolean isSuccessMessageDisplayed = paymentFlowPage.validateVerificationMessage(testdataProperties.getProperty("MobileNumber"));
		assertEquals(isSuccessMessageDisplayed, true);
	}

}

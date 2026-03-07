package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ecom.basePage.BasePage;

public class CartPage extends BasePage {
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	//Storing the locator of the "Checkout" button using By class:
	By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");
	By addToCartToastMessage = By.xpath("//div[@id='toast-container']");
	By LoginSuccessfulToastMessage = By.xpath("(//div[normalize-space()='Login Successfully'])[2]");
	
	//Action method to click on the "Checkout" button:
	public void clickCheckoutButton()
	{
		//First wait for the toast messages to disappear:
		//invisibilityOfElementLocated(addToCartToastMessage);
		
		//Now click on the "Checkout" button once the toast message is no longer visible:
		driver.findElement(checkoutButton).click();
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
	public void verifySuccessfulNavigationToCartPage()
	{
		//Before we verify, that CheckOut button is displayed, we need to wait for the toast message to disappear as it may block the view of the Checkout button and cause the assertion to fail:
		invisibilityOfElementLocated(addToCartToastMessage);
		//With By class, we have to follow below format to perform assertion on an element:
		Assert.assertTrue(driver.findElement(checkoutButton).isDisplayed(), "User is not navigated to the cart page successfully as Checkout button is not found.");
		//Also, because of this assertion in "main" folder, <scope>test</scope> is not working in pom.xml file during Jenkins run.
		// So use this assertion in "test" folder in "TestClasses" directly to keep the <scope>test</scope> working in pom.xml file during Jenkins run.
	}
	
}

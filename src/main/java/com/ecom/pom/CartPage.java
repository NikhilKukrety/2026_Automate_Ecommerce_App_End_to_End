package com.ecom.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecom.basePage.BasePage;

public class CartPage extends BasePage {
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	//Storing the locator of the "Checkout" button using By class:
	By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");
	By addToCartToastMessage = By.xpath("//div[@id='toast-container']");
	
	//Action method to click on the "Checkout" button:
	public void clickCheckoutButton()
	{
		//First wait for the toast message to disappear:
		invisibilityOfElementLocated(addToCartToastMessage);
		//Now click on the "Checkout" button once the toast message is no longer visible:
		driver.findElement(checkoutButton).click();
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
	public void verifySuccessfulNavigationToCartPage()
	{
		//With By class, we have to follow below format to perform assertion on an element:
		Assert.assertTrue(driver.findElement(checkoutButton).isDisplayed(), "User is not navigated to the cart page successfully as Checkout button is not found.");
		System.out.println("User is navigated to the cart page successfully as Checkout button is found.");
	}
	
}

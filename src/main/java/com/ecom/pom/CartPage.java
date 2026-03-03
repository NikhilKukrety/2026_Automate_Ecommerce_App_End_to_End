package com.ecom.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
}

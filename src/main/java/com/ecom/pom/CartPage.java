package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		/*Use the Java Script executor (first 3 lines of code) to click login button when using headless mode.
		 * This is because in headless mode, some elements may not be interactable using the standard WebDriver click method due to the absence of a visible UI,
		 * and using JavaScript to click on the element can help bypass these issues and ensure that the click action is performed successfully.*/
		WebElement element = driver.findElement(checkoutButton); //Changing the type of checkoutButton from By to WebElement to use it in JavaScript executor.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		//First wait for the toast messages to disappear:
		invisibilityOfElementLocated(addToCartToastMessage);
		
		//Use below code (2 lines) when not using headless mode for chrome browser (checkoutButton uses the By class here):
		
		//Adding below line explicitly as this test is flaky and we are making sure 100% that Checkout button is visible before clicking on it:
		//wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
		
		//Now click on the "Checkout" button once the toast message is no longer visible:
		//driver.findElement(checkoutButton).click();
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
	public void verifySuccessfulNavigationToCartPage()
	{
		//Use this Java Script executor when launching chrome in headless mode. Otherwise, it can be commented also:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(350,150);");
		
		//Before we verify, that CheckOut button is displayed, we need to wait for the toast message to disappear as it may block the view of the Checkout button and cause the assertion to fail:
		invisibilityOfElementLocated(addToCartToastMessage);
		//With By class, we have to follow below format to perform assertion on an element:
		Assert.assertTrue(driver.findElement(checkoutButton).isDisplayed(), "User is not navigated to the cart page successfully as Checkout button is not found.");
		//Also, because of this assertion in "main" folder, <scope>test</scope> is not working in pom.xml file during Jenkins run.
		// So use this assertion in "test" folder in "TestClasses" directly to keep the <scope>test</scope> working in pom.xml file during Jenkins run.
	}
	
}

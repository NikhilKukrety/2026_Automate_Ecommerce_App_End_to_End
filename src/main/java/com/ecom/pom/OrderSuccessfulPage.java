package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ecom.basePage.BasePage;

public class OrderSuccessfulPage extends BasePage {
	
	
	public OrderSuccessfulPage(WebDriver driver) {
		super(driver);
	}

	//Storing Sign Out button locator:
	By signOutButton = By.xpath("//button[normalize-space()='Sign Out']");
	
	//Action method to click on the Sign Out button:
	public void clickSignOutButton()
	{
		
		//Move to the top of the page to ensure the Sign Out button is in view before clicking on it using JavascriptExecutor:
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
		
		//Wait for the Sign Out button to become visible before clicking on it:
		visibilityOfElementLocated(signOutButton);
		
		/*Move to the Sign Out button to ensure it is in view before clicking on it using Actions class's below method:
		moveToElement(driver.findElement(signOutButton));*/
		
		//Wait for the Sign Out button to become clickable and then click on it:
		elementToBeClicked(signOutButton);
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
			public void verifySuccessfulNavigationToOrderSuccessfulPage()
			{
				//With By class, we have to follow below format to perform assertion on an element:
				Assert.assertTrue(driver.findElement(signOutButton).isDisplayed(), "User is not navigated to the Successful Order page successfully as SignOut Button is not found.");
				
			}
}

package com.ecom.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecom.basePage.BasePage;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Storing the product preview button locator using By class:
	By viewButton = By.xpath("//button[normalize-space()='View']");
	
	//Action method to click on the product preview button after it becomes clickable:
	public void clickViewButton()
	{
		elementToBeClicked(viewButton);
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
		public void verifySuccessfulNavigationToHomePage()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(viewButton));
			//With By class, we have to follow below format to perform assertion on an element:
			Assert.assertTrue(driver.findElement(viewButton).isDisplayed(), "User is not navigated to the home page successfully as View button is not found.");
			//Also, because of this assertion in "main" folder, <scope>test</scope> is not working in pom.xml file during Jenkins run.
			// So use this assertion in "test" folder in "TestClasses" directly to keep the <scope>test</scope> working in pom.xml file during Jenkins run.
		}
}

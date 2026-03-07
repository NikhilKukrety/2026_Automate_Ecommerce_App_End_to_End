package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ecom.basePage.BasePage;

public class PaymentPage extends BasePage {
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	//Storing Credit Card Number locator using By class:
	By creditCardNumber = By.xpath("(//input[contains(@class,'input txt text-validated')])[1]");
	By ccvNumber = By.xpath("(//input[contains(@class,'input txt')])[2]");
	By nameOnCard = By.xpath("(//input[contains(@class,'input txt')])[3]");
	By country = By.xpath("//input[@placeholder='Select Country']");
	By selectedContry = By.xpath("//span[normalize-space()='India']");
	By placeOrderButton = By.xpath("//a[normalize-space()='Place Order']");
	
	//Action method to enter the credit card number:
	public void enterCreditCardNumber(String cardNumber)
	{
		elementToBeClicked(creditCardNumber);
		driver.findElement(creditCardNumber).clear();
		driver.findElement(creditCardNumber).sendKeys(cardNumber);
	}
	
	//Action method to enter the CCV number:
	public void enterCCVNumber(String ccv)
	{
		driver.findElement(ccvNumber).sendKeys(ccv);
	}
	
	//Action method to enter the name on the card:
	public void enterNameOnCard(String name)
	{
		driver.findElement(nameOnCard).sendKeys(name);
	}
	
	//Action method to enter the country:
	public void enterCountry(String countryName)
	{
		driver.findElement(country).sendKeys(countryName);
	}
	
	//Action method to select the country from the suggestion but first wait for the suggestion to be visible:
	public void selectCountry()
	{
		elementToBeClicked(selectedContry);
	}
	
	//Action method to click on the "Place Order" button:
	public void clickPlaceOrderButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Move to the bottom of the page to click on the "Place Order" button:
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		//Wait for the "Place Order" button to be visible and then click on it:
		elementToBeClicked(placeOrderButton);
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
		public void verifySuccessfulNavigationToPaymentPage()
		{
			//With By class, we have to follow below format to perform assertion on an element:
			Assert.assertTrue(driver.findElement(creditCardNumber).isDisplayed(), "User is not navigated to the payments page successfully as Credit Card Number field is not found.");
			//Also, because of this assertion in "main" folder, <scope>test</scope> is not working in pom.xml file during Jenkins run.
			// So use this assertion in "test" folder in "TestClasses" directly to keep the <scope>test</scope> working in pom.xml file during Jenkins run.
		}
	

}	
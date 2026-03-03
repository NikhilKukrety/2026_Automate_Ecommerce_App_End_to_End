package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecom.basePage.BasePage;

public class SignInPage extends BasePage {
	
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	//Storing the locators of the elements in the SignInPage using By class:
	By email = By.id("userEmail");
	By password = By.id("userPassword");
	By loginButton = By.id("login");

	//Action methods to perform the login operation:
	public void enterEmail(String emailId)
	{
		driver.findElement(email).sendKeys(emailId);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
}

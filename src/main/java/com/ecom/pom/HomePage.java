package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}

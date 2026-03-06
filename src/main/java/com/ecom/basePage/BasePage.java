package com.ecom.basePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.utils.ConfigReader;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		ConfigReader config = new ConfigReader();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(config.getTimeoutInSeconds()));
	}
	
	//Reusable method to click on an element after waiting for it to be clickable:
	public void elementToBeClicked(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	//Reusable method to wait for the invisibility of an element located by a specific locator:
	public void invisibilityOfElementLocated(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	//Reusable method to wait for the visibility of an element located by a specific locator:
	public void visibilityOfElementLocated(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Reusable method to move to an element located by a specific locator using Actions class:
	public void moveToElement(WebElement locator) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(locator).perform();
		
	}
			
	
}


package com.ecom.basePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
	}
	
	//Reusable method to click on an element after waiting for it to be clickable:
	public void elementToBeClicked(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	//Reusable method to wait for the invisibility of an element located by a specific locator:
	public void invisibilityOfElementLocated(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

}

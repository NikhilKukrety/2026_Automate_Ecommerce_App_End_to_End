package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecom.basePage.BasePage;

public class ProductPreviewPage extends BasePage {
	
	
	public ProductPreviewPage(WebDriver driver) {
		super(driver);
	}
	
	//Storing "Add to Cart" button locator using By class:
	By addToCartButton = By.xpath("//button[normalize-space()='Add to Cart']");
	By CartButton = By.xpath("//button[@routerlink='/dashboard/cart']");
	
	//Action method to click on the "Add to Cart" button after it becomes clickable:
	public void clickAddToCartButton()
	{
		elementToBeClicked(addToCartButton);
	}
	
	//Action method to click on the "Cart" button:
	public void clickCartButton()
	{
		driver.findElement(CartButton).click();
	}
	

}

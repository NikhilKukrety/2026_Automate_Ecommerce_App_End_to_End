package com.ecom.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
			public void verifySuccessfulNavigationToProductPreviewPage()
			{
				//With By class, we have to follow below format to perform assertion on an element:
				Assert.assertTrue(driver.findElement(addToCartButton).isDisplayed(), "User is not navigated to the Product Preview page successfully as Add to Cart button is not found.");
				//Also, because of this assertion in "main" folder, <scope>test</scope> is not working in pom.xml file during Jenkins run.
				// So use this assertion in "test" folder in "TestClasses" directly to keep the <scope>test</scope> working in pom.xml file during Jenkins run.
			}
	

}

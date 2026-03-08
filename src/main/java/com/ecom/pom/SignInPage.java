package com.ecom.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.ecom.basePage.BasePage;

public class SignInPage extends BasePage {
	
	//It should be private (used within the same class for logging purposes) and static (shared among all instances of the SignInPage class) because it is used for logging messages related to the SignInPage class, and it does not need to be accessed or modified by other classes or instances. By making it private and static, we ensure that it is only accessible within the SignInPage class and that there is only one instance of the logger shared among all instances of the SignInPage class, which is sufficient for logging purposes in this context. Final because log reference should not be changed.
	private static final Logger log = LogManager.getLogger(SignInPage.class);
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Storing the locators of the elements in the SignInPage using By class:
	By email = By.id("userEmail");
	By password = By.id("userPassword");
	//By loginButton = By.id("login");
	By loginButton = By.xpath("//input[@value='Login']");

	//Action methods to perform the login operation:
	public void enterEmail(String emailId)
	{
		driver.findElement(email).sendKeys(emailId);
		log.info("Entered email: "+emailId);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
		log.info("Entered password: "+pass);
		
	}
	
	public void clickLoginButton()
	{
		/*Use the Java Script executor (first 3 lines of code) to click login button when using headless mode.
		 * This is because in headless mode, some elements may not be interactable using the standard WebDriver click method due to the absence of a visible UI,
		 * and using JavaScript to click on the element can help bypass these issues and ensure that the click action is performed successfully.*/
		WebElement element = driver.findElement(loginButton); //Changing the type of loginButton from By to WebElement to use it in JavaScript executor.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		//Use below code (3 lines) when not using headless mode for chrome browser (loginButton uses the By class here):
		/*visibilityOfElementLocated(loginButton);
		elementToBeClicked(loginButton);
		driver.findElement(loginButton).click();*/
		
		//Logging the click action:
		log.info("Clicked on the login button.");
	}
	
	//Method to verify if user is navigated to the login page successfully by verifying the presence of email field:
	public void verifySuccessfulNavigationToSignInPage()
	{
		//With By class, we have to follow below format to perform assertion on an element:
		Assert.assertTrue(driver.findElement(email).isDisplayed(), "User is not navigated to the login page successfully as email field is not found.");
		//Also, because of this assertion in "main" folder, <scope>test</scope> is not working in pom.xml file during Jenkins run.
				// So use this assertion in "test" folder in "TestClasses" directly to keep the <scope>test</scope> working in pom.xml file during Jenkins run.
	}
}

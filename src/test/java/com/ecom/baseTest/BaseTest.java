package com.ecom.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected static WebDriver driver;
	//Commenting this so that the browser is launched and closed for each scenario in the Hooks class, which is more suitable for Cucumber tests. If we keep the @BeforeClass and @AfterClass annotations here, the browser will be launched only once before all the tests and closed after all the tests, which may not be ideal for Cucumber scenarios that require a fresh browser instance for each scenario to ensure test isolation and reliability.
	
	
	@BeforeClass
	public void launchChromeBrowser()
	{
		//Giving life to the driver by initializing it with the ChromeDriver class, which will launch the Chrome browser.
		driver = new ChromeDriver();
		
		//Navigating to the URL of the application under test:
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		//Maximizing the browser window:
		driver.manage().window().maximize();

}
	
	@AfterClass
	public void tearDown()
	{
		//Closing the browser and quitting the driver instance:
		driver.quit();
	}
	
	//Getter method to access the WebDriver instance to other classes:
	public WebDriver getDriver() {
		return driver;
	}
}

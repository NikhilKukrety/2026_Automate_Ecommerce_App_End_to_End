package com.ecom.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	protected WebDriver driver;
	
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
	
}

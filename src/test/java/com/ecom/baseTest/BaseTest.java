package com.ecom.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.ecom.utils.ConfigReader;

public class BaseTest {
	
	protected static WebDriver driver;
	//Commenting this so that the browser is launched and closed for each scenario in the Hooks class, which is more suitable for Cucumber tests. If we keep the @BeforeClass and @AfterClass annotations here, the browser will be launched only once before all the tests and closed after all the tests, which may not be ideal for Cucumber scenarios that require a fresh browser instance for each scenario to ensure test isolation and reliability.
	
	
	@BeforeClass
	public void launchChromeBrowser()
	{
		//Creating an object of the ConfigReader class to read the configuration settings from the config.properties file, which contains key-value pairs of configuration settings for the test automation framework.
				ConfigReader config = new ConfigReader();
				
				//The getBrowser() method is called to retrieve the value of the "browser" property from the loaded properties file, allowing the test automation framework to access and utilize the specified browser configuration for test execution.
				String browser = config.getBrowser();
				
				if(browser.equalsIgnoreCase("chrome")) {
					//Giving life to the driver by initializing it with the ChromeDriver class, which will launch the Chrome browser.
					 driver = new ChromeDriver();
				}
				else if (browser.equalsIgnoreCase("firefox")) {
					//Code to initialize the WebDriver instance with FirefoxDriver for Firefox browser
					driver = new FirefoxDriver();
				}
				else if (browser.equalsIgnoreCase("edge")) {
					//Code to initialize the WebDriver instance with EdgeDriver for Edge browser
					driver = new EdgeDriver();
					
				}
				
		//Maximizing the browser window:
		driver.manage().window().maximize();
		
		//Navigating to the URL of the application under test:
		driver.get(config.getBaseUrl());
		


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

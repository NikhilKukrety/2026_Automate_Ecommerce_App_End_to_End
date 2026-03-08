package com.ecom.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.ecom.baseTest.BaseTest;
import com.ecom.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
	
	//It should be private (used within the same class for logging purposes) and static (shared among all instances of the BaseTest class) because it is used for logging messages related to the BaseTest class, and it does not need to be accessed or modified by other classes or instances. By making it private and static, we ensure that it is only accessible within the BaseTest class and that there is only one instance of the logger shared among all instances of the BaseTest class, which is sufficient for logging purposes in this context. Final because log reference should not be changed.
		private static final Logger log = LogManager.getLogger(BaseTest.class);
	
	@Before //This annotation indicates that the method should be executed before each scenario in the Cucumber test suite. It is used to set up the necessary preconditions for the tests, such as launching the browser and navigating to the application under test.
	public void setUp() {	
		
		//Creating an object of the ConfigReader class to read the configuration settings from the config.properties file, which contains key-value pairs of configuration settings for the test automation framework.
		ConfigReader config = new ConfigReader();
		//The getBrowser() method is called to retrieve the value of the "browser" property from the loaded properties file, allowing the test automation framework to access and utilize the specified browser configuration for test execution.
		String browser = config.getBrowser();
		
		//Logging the browser that is being launched using the Log4j logger, which will help in tracking the browser being used for test execution in the logs.
		log.info("Launching browser: "+browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			
		    //Use below 4 lines of code if you want to run the cucumber tests in headless mode for chrome browser:
			//Defining ChromeOptions to set specific options for the Chrome browser, such as running in headless mode, disabling extensions, or setting other preferences. This allows for customization of the browser behavior during test execution.
            ChromeOptions options = new ChromeOptions();
            //Add an argument for running in headless mode (no visible UI):
            options.addArguments("--headless=new");
			//Maximizing the browser window to a particular size to ensure that the tests run in a consistent environment and to avoid any issues related to element visibility or layout that may arise when running in headless mode:
			options.addArguments("--window-size=1920,1080");
			 //Adding below line to disable GPU hardware acceleration, which can help improve performance and stability when running in headless mode, especially on systems that may have limited GPU resources or when running in environments where GPU support is not available:
			options.addArguments("--disable-gpu");
				//Giving life to the driver by initializing it with the ChromeDriver class, which will launch the Chrome browser.
			driver = new ChromeDriver(options);
			 
			 
			 //Uncomment the below line when not using headless mode for chrome browser:
			 //driver = new ChromeDriver();
			 
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			//User below 4 lines of code if you want to run the cucumber tests in headless mode for firefox browser:
			//Defining FireFoxOptions to set specific options for the firefox browser, such as running in headless mode, disabling extensions, or setting other preferences. This allows for customization of the browser behavior during test execution.
            FirefoxOptions options = new FirefoxOptions();
            //Add an argument for running in headless mode (no visible UI):
            options.addArguments("--headless=new");
			//Maximizing the browser window to a particular size to ensure that the tests run in a consistent environment and to avoid any issues related to element visibility or layout that may arise when running in headless mode:
			options.addArguments("--window-size=1920,1080");
			 //Adding below line to disable GPU hardware acceleration, which can help improve performance and stability when running in headless mode, especially on systems that may have limited GPU resources or when running in environments where GPU support is not available:
			options.addArguments("--disable-gpu");
			//Giving life to the driver by initializing it with the FirefoxDriver class, which will launch the Firefox browser.
			driver = new FirefoxDriver(options);
			 
			 
			 //Uncomment the below line when not using headless mode for firefox browser:
			 //driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			
			//User below 4 lines of code if you want to run the cucumber tests in headless mode for Edge browser:
			//Defining EdgeOptions to set specific options for the Edge browser, such as running in headless mode, disabling extensions, or setting other preferences. This allows for customization of the browser behavior during test execution.
            EdgeOptions options = new EdgeOptions();
            //Add an argument for running in headless mode (no visible UI):
            options.addArguments("--headless=new");
			//Maximizing the browser window to a particular size to ensure that the tests run in a consistent environment and to avoid any issues related to element visibility or layout that may arise when running in headless mode:
			options.addArguments("--window-size=1920,1080");
			 //Adding below line to disable GPU hardware acceleration, which can help improve performance and stability when running in headless mode, especially on systems that may have limited GPU resources or when running in environments where GPU support is not available:
			options.addArguments("--disable-gpu");
			//Giving life to the driver by initializing it with the EdgeDriver class, which will launch the Edge browser.
			driver = new EdgeDriver(options);
			
			//Uncomment the below line when not using headless mode for Edge browser:
			//driver = new EdgeDriver();
			
		}
		
		//Use below code to maximize window when not using headless mode. It is applicable to all browsers:
		//driver.manage().window().maximize();
		
		//Navigating to the URL of the application under test:
		driver.get(config.getBaseUrl());
		//Logging the URL that is being navigated to using the Log4j logger, which will help in tracking the application under test being accessed in the logs.
		log.info("Navigating to URL: "+config.getBaseUrl());
	
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File("./target/Cucumber_Failure_screenshot.png");
	        try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Code to capture screenshot and attach it to the Cucumber report
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		driver.quit();
		
	}
	
	//Getter method to access the WebDriver instance to other classes:
	public WebDriver getDriver() {
		return driver;
	}

}

package com.ecom.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.baseTest.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
	
	@Before //This annotation indicates that the method should be executed before each scenario in the Cucumber test suite. It is used to set up the necessary preconditions for the tests, such as launching the browser and navigating to the application under test.
	public void setUp() {	
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	
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

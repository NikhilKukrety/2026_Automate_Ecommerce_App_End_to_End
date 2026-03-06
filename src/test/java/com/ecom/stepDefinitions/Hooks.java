package com.ecom.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			//Code to capture screenshot and attach it to the Cucumber report
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		driver.quit();
		
	}

}

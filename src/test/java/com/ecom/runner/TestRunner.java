package com.ecom.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@Listeners(com.ecom.listeners.Listeners.class)
@CucumberOptions(
			features = "src/test/resources/features",
			glue = {"com.ecom.stepDefinitions","com.ecom.hooks"},
			plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"},
			monochrome = true,
			tags = "@EndToEndTest1"
			)
	
	public class TestRunner extends AbstractTestNGCucumberTests {
		//This class is intentionally left empty. It serves as a test runner for Cucumber tests, and the annotations and configurations specified in the @CucumberOptions annotation will be used to execute the tests defined in the feature files.

}

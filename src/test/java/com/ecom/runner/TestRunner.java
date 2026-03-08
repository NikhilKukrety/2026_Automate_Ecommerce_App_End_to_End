package com.ecom.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class) -> This is used when we use Cucumber + JUnit framework for running the tests. 
//This annotation is used to specify that the ExtentReportListener class should be used as a listener for the test execution. The ExtentReportListener class is responsible for generating the Extent Reports based on the test results and events during the execution of the Cucumber tests.
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

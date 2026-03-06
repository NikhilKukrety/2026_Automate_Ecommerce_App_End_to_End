package com.ecom.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ecom.baseTest.BaseTest;
import com.ecom.utils.ExtentReportManager;

public class Listeners implements ITestListener {
	//This class implements the ITestListener interface from TestNG, which allows you to listen to various events during the test execution, such as when a test starts, finishes, fails, etc. You can override the methods of the ITestListener interface to perform specific actions based on these events, such as logging, taking screenshots, or generating reports. The implementation of these methods is not shown in the provided code snippet, but you can customize them according to your requirements.
	
	
	ExtentReports extent = ExtentReportManager.getReportInstance();
	ExtentTest test;
	@Override
    public void onTestStart(ITestResult result) {
		
		//The onTestStart() method is called when a test method starts executing. In this implementation, it creates a new test entry in the Extent Report using the createTest() method of the ExtentReports class, passing the name of the test method as an argument. It also prints a message to the console indicating that the test has started, along with the name of the test method.
		test = extent.createTest(result.getMethod().getMethodName());
        System.out.println("Hi Nikhil, Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Hi Nikhil, Test passed: " + result.getName());
        //The onTestSuccess() method is called when a test method finishes executing successfully. In this implementation, it prints a message to the console indicating that the test has passed, along with the name of the test method. It also logs the status of the test as "PASS" in the Extent Report using the log() method of the ExtentTest class, passing the Status.PASS enum value and a message indicating that the test has passed.
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Hi Nikhil, Test failed: " + result.getName());
        //The onTestFailure() method is called when a test method finishes executing with a failure. In this implementation, it prints a message to the console indicating that the test has failed, along with the name of the test method. It also logs the status of the test as "FAIL" in the Extent Report using the log() method of the ExtentTest class, passing the Status.FAIL enum value and a message indicating that the test has failed. Additionally, it logs the throwable (exception) that caused the failure in the Extent Report using the log() method, passing the Status.FAIL enum value and the throwable obtained from the ITestResult object.
        test.fail(result.getThrowable());
        //Get the instance of the WebDriver from the BaseTest class to capture the screenshot:
        Object currentClassInstance = result.getInstance();
        //Cast to BaseTest to access the getDriver() method and retrieve the WebDriver instance:
        WebDriver driver = ((BaseTest) currentClassInstance).getDriver();
        //Code to capture screenshot and save it to a specific location:
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("./test-output/TestNG_Failure_screenshot.png");
        try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Hi Nikhil, Test skipped: " + result.getName());
    }
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hi Nikhil, Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        //The onFinish() method is called when the entire test execution is finished. In this implementation, it prints a message to the console indicating that the test execution has finished, along with the name of the test context. It also calls the flush() method of the ExtentReports class to ensure that all the logged information is written to the report file and the report is generated properly.
        extent.flush();
    }

		
	}


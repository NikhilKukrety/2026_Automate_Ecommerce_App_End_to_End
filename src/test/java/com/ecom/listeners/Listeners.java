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

import com.ecom.baseTest.BaseTest;

public class Listeners implements ITestListener {
	//This class implements the ITestListener interface from TestNG, which allows you to listen to various events during the test execution, such as when a test starts, finishes, fails, etc. You can override the methods of the ITestListener interface to perform specific actions based on these events, such as logging, taking screenshots, or generating reports. The implementation of these methods is not shown in the provided code snippet, but you can customize them according to your requirements.
	
	@Override
    public void onTestStart(ITestResult result) {
        System.out.println("Hi Nikhil, Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Hi Nikhil, Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Hi Nikhil, Test failed: " + result.getName());
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
        System.out.println("Hi Nikhil, Test execution finished: " + context.getName());
    }

		
	}


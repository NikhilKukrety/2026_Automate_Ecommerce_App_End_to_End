package com.ecom.utils;

import java.io.FileInputStream;
import java.util.Properties;

//It is a utility class that is responsible for reading the configuration settings from a properties file (config.properties) and providing methods to access those settings. 
public class ConfigReader {
	
	Properties prop;
	
	public ConfigReader() {
		
		prop = new Properties();
		
		try {
		
		//InputStream fis = getClass().getClassLoader().getResourceAsStream("config.properties");
		
		//The FileInputStream class is used to read the contents of the config.properties file, which contains key-value pairs of configuration settings for the test automation framework.
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		
		//The load() method of the Properties class is called to load the properties from the FileInputStream, allowing the test automation framework to access and utilize the configuration settings defined in the config.properties file during test execution.
		prop.load(fis);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//The getBrowser() method is a public method that retrieves the value of the "browser" property from the loaded properties file, allowing other parts of the test automation framework to access and utilize the specified browser configuration for test execution.
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	//The getBaseUrl() method is a public method that retrieves the value of the "baseUrl" property from the loaded properties file, allowing other parts of the test automation framework to access and utilize the specified base URL configuration for test execution.
	public String getBaseUrl() {
		return prop.getProperty("baseUrl");
	}
	
	//The getTimeout() method is a public method that retrieves the value of the "timeout" property from the loaded properties file, allowing other parts of the test automation framework to access and utilize the specified timeout configuration for test execution.
	/*public String getTimeout() {
		return prop.getProperty("timeout");
	}*/
	
	//The getTimeoutInSeconds() method is a public method that retrieves the value of the "timeout" property from the loaded properties file, converts it from a String to an integer using Integer.parseInt(), and returns the timeout value in seconds, allowing other parts of the test automation framework to access and utilize the specified timeout configuration for test execution in a numerical format.
	public int getTimeoutInSeconds() {
	    return Integer.parseInt(prop.getProperty("timeout"));
	    }
	
	//Creating username method only for TestNG tests and not for Cucumber tests, as there is only 1 pair of username and password for TestNG tests. In Cucumber tests, we are using scenario outline for 2 or more pairs of username and password.
	public String getUsername() {
		return prop.getProperty("username");
	}
	
	//Creating password method only for TestNG tests and not for Cucumber tests, as there is only 1 pair of username and password for TestNG tests. In Cucumber tests, we are using scenario outline for 2 or more pairs of username and password.
	public String getPassword() {
		return prop.getProperty("password");
	}

}
package com.ecom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
	public String getTimeout() {
		return prop.getProperty("timeout");
	}
	
	//The getTimeoutInSeconds() method is a public method that retrieves the value of the "timeout" property from the loaded properties file, converts it from a String to an integer using Integer.parseInt(), and returns the timeout value in seconds, allowing other parts of the test automation framework to access and utilize the specified timeout configuration for test execution in a numerical format.
	public int getTimeoutInSeconds() {
	    return Integer.parseInt(prop.getProperty("timeout"));
	    }
	
	}

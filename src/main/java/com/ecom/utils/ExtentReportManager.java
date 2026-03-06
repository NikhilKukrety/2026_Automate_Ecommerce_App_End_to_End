package com.ecom.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//It is a utility class that is responsible for managing the Extent Reports in the test automation framework. The ExtentReportManager class can include methods and functionalities to initialize, configure, and generate Extent Reports based on the test execution results. It can also handle the creation of report files, adding test logs, and customizing the report layout and appearance according to the requirements of the test automation framework. The implementation of these methods and functionalities is not shown in the provided code snippet, but it can be customized based on the specific needs of the project.
public class ExtentReportManager {
	
	//The extent variable is declared as private and static, which means it can only be accessed within the ExtentReportManager class and is shared among all instances of the class. This variable will hold the instance of the ExtentReports object that will be used to generate the test reports.
	private static ExtentReports extent;
	
	//The getExtentReport() method is a public static method that returns an instance of the ExtentReports class. It checks if the extent variable is null, which means that the ExtentReports object has not been initialized yet. If it is null, it creates a new instance of the ExtentSparkReporter class, which is responsible for generating the HTML report, and configures it with the desired report name and document title. Then, it creates a new instance of the ExtentReports class and attaches the ExtentSparkReporter to it. Finally, it returns the initialized ExtentReports object.
	public static ExtentReports getReportInstance() {
		//The if statement checks if the extent variable is null, which means that the ExtentReports object has not been initialized yet. If it is null, it creates a new instance of the ExtentSparkReporter class, which is responsible for generating the HTML report, and configures it with the desired report name and document title. Then, it creates a new instance of the ExtentReports class and attaches the ExtentSparkReporter to it. Finally, it returns the initialized ExtentReports object.
		if (extent == null) {
			
			//The ExtentSparkReporter class is used to generate the HTML report for the test execution. It is initialized with the file path where the report will be saved, in this case, "reports/TestReport.html". The config() method is used to configure the report settings, such as setting the report name and document title.
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/TestReport.html");
			//The setReportName() method is used to set the name of the report that will be displayed in the generated HTML report. In this case, it is set to "E-commerce Automation Test Report".
			spark.config().setReportName("E-commerce Automation Test Report");
			//The setDocumentTitle() method is used to set the title of the HTML document that will be generated for the report. In this case, it is set to "E-commerce Automation Test Report".
			spark.config().setDocumentTitle("E-commerce Automation Test Report");
			
			//The ExtentReports class is used to create an instance of the ExtentReports object, which will be used to generate the test reports. The attachReporter() method is called to attach the ExtentSparkReporter to the ExtentReports instance, allowing it to generate the HTML report based on the test execution results.
			extent = new ExtentReports();
			//The attachReporter() method is called to attach the ExtentSparkReporter to the ExtentReports instance, allowing it to generate the HTML report based on the test execution results.
			extent.attachReporter(spark);
			
		}
		return extent;
	}

}

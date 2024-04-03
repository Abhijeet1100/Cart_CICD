package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


	public static ExtentReports getReportObject()
	{

	ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/index.html");

	reporter.config().setDocumentTitle("Ecommerce Testing");


	reporter.config().setReportName("Testing Reports");
	
	


	ExtentReports reports = new ExtentReports();

	reports.attachReporter(reporter);

	reports.setSystemInfo("Testeur", " Mr. Mandal");

	return reports;
	}

}

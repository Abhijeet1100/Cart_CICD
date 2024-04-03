package Base;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestComponent.TestComponents;
import Utility.ExtentReporterNG;

public class Listerners extends TestComponents implements ITestListener{

    ExtentReports reports = ExtentReporterNG.getReportObject();
   
    ExtentTest test;
    
    WebDriver driver;

	@Override
	public void onTestStart(ITestResult result)
	{
		
		test = reports.createTest(result.getMethod().getMethodName());
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		
		test.log(Status.PASS,"Test Passed");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
		test.fail("Test fail");
		
		test.fail(result.getThrowable());
		
	    String filePath=null;
	    
	    
	    try {
		//	driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
		} 
	    catch (Exception e) 
	    {
			
			e.printStackTrace();
		} 
	    
		try {
			
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
			
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		
		
		
		
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		
		reports.flush();
		
	}




}

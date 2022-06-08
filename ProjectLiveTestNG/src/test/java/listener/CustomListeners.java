package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;



public class CustomListeners implements ITestListener {
	ExtentTest test;
	ExtentReports rep;
	
//	public void onTestStart(ITestResult result)
//	{
//		test =(ExtentTest)result.getAttribute("report");
//		test.log(Status.INFO, "Test is started");
//	}
	
	public void onTestFailure(ITestResult result) {
		
		test =(ExtentTest)result.getAttribute("report");
		System.out.println("IListeners:--- Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		test =(ExtentTest)result.getAttribute("report");
		System.out.println("IListeners:--- Test Passed");
		test.log(Status.PASS, "Working Fine");
	}
	
	public void onTestSkipped(ITestResult result) {
		rep = ExtentManager.getReports();
		test = (ExtentTest)rep.createTest(result.getMethod().getMethodName().toUpperCase());
		System.out.println("IListeners:--- Test Passed");
		test.log(Status.SKIP, "Test Has Been Skipped");
	}
	public void onStart(ITestContext context, ITestResult result)
	{
		test =(ExtentTest)result.getAttribute("report");
		System.out.println("This is executed first");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("This is executed last");
	}

}

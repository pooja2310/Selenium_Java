package org.example.test_scenarios;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class CustomListener implements ITestListener {
	
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override
	public void onStart(ITestContext context) {
		// Initialize report only once
		String reportPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "LiveExtentReport.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Framework", "Selenium + TestNG");
		extent.setSystemInfo("Tester", "Your Name");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		extentTest.log(Status.INFO, "Test Started: " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed");
		test.get().log(Status.FAIL, result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped");
		test.get().log(Status.SKIP, result.getThrowable());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}

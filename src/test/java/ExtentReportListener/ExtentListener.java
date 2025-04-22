package ExtentReportListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentListener implements IReporter {
	
	private ExtentReports extent;
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		ExtentSparkReporter spark = new ExtentSparkReporter(outputDirectory + File.separator + "ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				
				buildTestNodes(context.getPassedTests(), Status.PASS);
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
			}
		}
		
		extent.flush();
	}
	
	private void buildTestNodes(IResultMap tests, Status status) {
		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				ExtentTest test = extent.createTest(result.getMethod().getMethodName());
				
				test.getModel().setStartTime(new Date(result.getStartMillis()));
				test.getModel().setEndTime(new Date(result.getEndMillis()));
				
				for (String group : result.getMethod().getGroups()) {
					test.assignCategory(group);
				}
				
				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}
			}
		}
	}
}

package com.crm.Vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListenerS implements ITestListener{
	
	JavaUtility ju = new JavaUtility();
	String date  = ju.getSystmeDate();
	
	ExtentReports reports;
	ExtentTest test;

	//Path of report and we can make change to look and feel of report
	
	public void onFinish(ITestContext arg0) {
		reports.flush();
		
	}

	public void onStart(ITestContext context) {
		
		
		
		String path = System.getProperty("user.dir")+"/ExtentReport/ExtentReportSdet1_"+ju.localDate()+".html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setDocumentTitle("SDET21");
		reporter.config().setReportName("Vtiger_Test");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Build No.", "5.1");
		reports.setSystemInfo("ENV", "Pre-Pod");
		reports.setSystemInfo("Platform", "Windows");
		reports.setSystemInfo("Browser-Version", "Chrome-93");
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		BaseClass basec =new BaseClass();
	
		try {
			String path = basec.getscreenshot(result.getName());
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		
	}


	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
		
	}


}

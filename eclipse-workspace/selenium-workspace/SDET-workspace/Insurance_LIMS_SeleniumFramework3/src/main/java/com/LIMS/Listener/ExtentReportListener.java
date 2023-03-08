package com.LIMS.Listener;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.LIMS.baseClass.ConfigurationClass;
import com.LIMS.genericUtility.annotations.Record;
import com.LIMS.genericUtility.instanceTransfer.UtilityInstanceTransfer;
import com.LIMS.genericUtility.reportUtility.ReportUtility;

/**
 * This class contains wil generate report of scripts takes screenshot of failed
 * testcases
 * 
 * @author kishore mallarapu
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener {
	private ReportUtility report;
	public static ReportUtility sreport;

	/**
	 * 
	 */
	@Override
	public void onTestStart(ITestResult result) {
		report.createTest(result.getMethod().getMethodName());
		Record reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Record.class);
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());

	}

	/**
	 * 
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName() + " is pass");

	}

	/**
	 * 
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName() + " is fail",
				result.getThrowable());
		String screenshotPath = ConfigurationClass.class.cast(result.getMethod().getInstance()).webDriverUtility
				.getScreenShot();
		report.attactScreenShot(UtilityInstanceTransfer.getExtentTest(), screenshotPath,
				result.getMethod().getMethodName(), "base64");

	}

	/**
	 * 
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName() + "is failed");
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getThrowable());

	}

	/**
	 * 
	 */

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	/**
	 * 
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	/**
	 * 
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start");
	}

	/**
	 * 
	 */
	@Override
	public void onStart(ISuite suite) {
		/*
		 * // TODO Auto-generated method stub PropertyUtility propertyUtility = null;
		 * try { propertyUtility = new
		 * PropertyUtility(AutoConstants.TEST_PROPERTY_FILE_PATH); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		report = new ReportUtility();
		/*
		 * report.init(AutoConstants.EXTENT_REPORT_PATH,
		 * propertyUtility.getPropertyData(PropertiesFile.EXTENTREPORTTITLE),
		 * propertyUtility.getPropertyData(PropertiesFile.EXTENTREPORTNAME),
		 * propertyUtility.getPropertyData(PropertiesFile.BROWSER));
		 */
		sreport = report;
	}

	/**
	 * 
	 */
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.saveReport();
	}

	/**
	 * 
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");

	}

}

package com.LIMS.genericUtility.reportUtility;

import java.io.IOException;

import com.LIMS.genericUtility.enums.AutoConstants;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.genericUtility.instanceTransfer.UtilityInstanceTransfer;
import com.LIMS.genericUtility.javaUtility.JavaUtility;
import com.LIMS.genericUtility.propertyUtility.PropertyUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class contains generic utility related to reports
 * @author kishore mallarapu
 *
 */
public class ReportUtility {

	private ExtentReports report;
/**
 * 
 */
	public ReportUtility() {
		init();
	}

	/**
	 * This method is used to initialize propertyutility, and change the report name and initialize some report utilities
	 */
	public void init() {

		PropertyUtility propertyUtility = null;
		try {
			propertyUtility = new PropertyUtility(AutoConstants.TEST_PROPERTY_FILE_PATH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String overrideOrNot = propertyUtility.getPropertyData(PropertiesFile.OVERRIDEREPORT);
		String randomName = "";

		if (overrideOrNot.equals("no")) {
			randomName = "_" + new JavaUtility().getCurrentDateTime();
		}
		ExtentSparkReporter spark = new ExtentSparkReporter(
				AutoConstants.EXTENT_REPORT_PATH + "extentReport" + randomName + "");
        
		spark.config().setDocumentTitle(propertyUtility.getPropertyData(PropertiesFile.EXTENTREPORTTITLE));
		spark.config().setReportName(propertyUtility.getPropertyData(PropertiesFile.EXTENTREPORTNAME));
		/*
		 * spark.config().setDocumentTitle(title);
		 * spark.config().setReportName(reportName);
		 */
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", System.getProperty("os.name"));
		

	}

	/**This method is used to create test
	 * 
	 * @param testName
	 */
	public void createTest(String testName) {
		ExtentTest test = report.createTest(testName);
		UtilityInstanceTransfer.setExtentTest(test);
	}

	/**
	 * 
	 * @param message
	 */
	public void fail(ExtentTest test, String message, Throwable errorMsg) {
		test.fail(message);
		test.fail(errorMsg);
		System.out.println(message);

	}

	/**
	 * This method is used to assign author
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names) {
		test.assignAuthor(names);
	}

	/**
	 * This method is used to add category of test script
	 * 
	 * @param names
	 */
	public void addCategory(ExtentTest test, String... names) {
		test.assignCategory(names);
	}

	/**
	 * 
	 * @param errorMessage
	 */

	/**
	 * this method will throw exception when a method got skipped
	 * @param errorMessage
	 */
	public void skip(ExtentTest test, Throwable errorMessage) {
		test.skip(errorMessage);
		System.out.println(errorMessage);
	}

	/**
	 * This method is used to print mag with pass 
	 * @param Message
	 */
	public void pass(ExtentTest test, String Message) {
		test.pass(Message);
		System.out.println(Message);
	}

	/**
	 * This method is used to print skip message in report and console
	 * @param Message
	 */
	public void skip(ExtentTest test, String Message) {
		test.skip(Message);
		System.out.println(Message);
	}

	/**This method is used to print info in report and console
	 * 
	 * @param Message
	 */
	public void info(ExtentTest test, String Message) {
		test.info(Message);
		System.out.println(Message);
	}

	/**
	 * This method will attach screenshot of failed test case with title
	 * @param screenshotPath
	 * @param title
	 * @param strategy
	 */
	public void attactScreenShot(ExtentTest test, String screenshotPath, String title, String strategy) {
		if (strategy.equalsIgnoreCase("base64")) {
			test.addScreenCaptureFromBase64String(screenshotPath, title);
		} else {
			test.addScreenCaptureFromPath(screenshotPath, title);
		}
	}

	/**
	 * This method will flush the data to report
	 */
	public void saveReport() {
		report.flush();
	}

}

package com.LIMS.baseClass;

import org.openqa.selenium.WebDriver;


import com.LIMS.genericUtility.excelUtility.ExcelUtility;
import com.LIMS.genericUtility.javaUtility.JavaUtility;
import com.LIMS.genericUtility.propertyUtility.PropertyUtility;
import com.LIMS.genericUtility.reportUtility.ReportUtility;
import com.LIMS.genericUtility.waitUtility.WaitUtility;
import com.LIMS.genericUtility.webDriverUtility.WebDriverUtility;
import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.LoginPage;
import com.aventstack.extentreports.ExtentTest;
/**
 * This class contains declarations of all generic classes.
 * @author kishore mallarapu
 *
 */
public class BaseClass {

	protected ExcelUtility excelUtility;

	protected PropertyUtility propertyUtility;
	public WebDriverUtility webDriverUtility;
	protected WaitUtility waitUtility;
	public WebDriver driver;
	protected String url;
	protected String username;
	protected String password;
	public JavaUtility javaUtility;
	protected String browser;
	protected LoginPage loginPage;
	protected int randomNumber;
	protected CommonPage commonPage;
	public ExtentTest test;
	protected ReportUtility report;

}

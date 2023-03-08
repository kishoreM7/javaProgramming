package com.LIMS.baseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.LIMS.Listener.ExtentReportListener;
import com.LIMS.genericUtility.enums.AutoConstants;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.genericUtility.excelUtility.ExcelUtility;
import com.LIMS.genericUtility.javaUtility.JavaUtility;
import com.LIMS.genericUtility.propertyUtility.PropertyUtility;
import com.LIMS.genericUtility.webDriverUtility.WebDriverUtility;
import com.LIMS.objectRepository.CommonPage;
import com.LIMS.objectRepository.LoginPage;

/**
 * This class contains configuration test methods
 * 
 * @author kishore mallarapu
 *
 */
public class ConfigurationClass extends BaseClass {
	/**
	 * This configuration method will initialize some generic utility classes
	 * 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	@BeforeClass(alwaysRun = true)
	public void intializeUtilitiesSetUp() throws EncryptedDocumentException, IOException {
		report = ExtentReportListener.sreport;
		excelUtility = new ExcelUtility(AutoConstants.TEST_EXCEL_FILE_PATH);
		propertyUtility = new PropertyUtility(AutoConstants.TEST_PROPERTY_FILE_PATH);
		webDriverUtility = new WebDriverUtility();
		javaUtility = new JavaUtility();

		// common data
		browser = propertyUtility.getPropertyData(PropertiesFile.BROWSER);
		url = propertyUtility.getPropertyData(PropertiesFile.URL);
		username = propertyUtility.getPropertyData(PropertiesFile.USERNAME);
		password = propertyUtility.getPropertyData(PropertiesFile.PASSWORD);
		randomNumber = javaUtility.generateRandomNumber(1000);

	}

	/**
	 * This configuration method launches browser
	 * 
	 * @param browser
	 * @throws IOException
	 */
	@Parameters(value = "browser")
	@BeforeMethod(alwaysRun = true)
	public void beforeMethodSetup(@Optional String browser) throws IOException {
		this.browser = browser;
		if (browser == null || browser.isEmpty() || browser.equals("")) {
			browser = propertyUtility.getPropertyData(PropertiesFile.BROWSER);
		}
		driver = webDriverUtility.launchWebBrowser(browser);
		webDriverUtility.waitForPageLoad(driver, 10);
		webDriverUtility.maximiseWindow(driver);
		commonPage = new CommonPage(driver);
		webDriverUtility.launchApplication(driver, url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(username, password);
	}

	/**
	 * This method will logout the application and close the driver
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		commonPage.logOut();
		webDriverUtility.close(driver);

	}

	/**
	 * This method will close excel utility
	 * 
	 * @throws IOException
	 */
	@AfterClass(alwaysRun = true)
	public void initialisationTearDown() throws IOException {
		excelUtility.close();

	}

}

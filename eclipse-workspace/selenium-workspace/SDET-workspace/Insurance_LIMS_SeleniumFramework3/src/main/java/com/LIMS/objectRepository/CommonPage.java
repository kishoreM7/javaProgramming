package com.LIMS.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the elements in home page of LIMS application
 * 
 * @author kishore mallarapu
 *
 */
public class CommonPage {
	private WebDriver driver;
	private String modulePartialXpath = "//a[text()='%s']";
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement logoutBtn;
	String name = "kishore";

	/**
	 * This method will convert partial xpath tp required element based on input
	 * passed
	 * 
	 * @param modulePartiString
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToElement(String modulePartiString, String replaceData) {
		String xPath = String.format(modulePartialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * This constructor will invoke the elements present in this class
	 * 
	 * @param driver
	 */
	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * used to click any module based on requirement by passing required arguements
	 * 
	 * @param moduleName
	 */
	public void clickModule(ModuleName moduleName) {
		convertToElement(modulePartialXpath, moduleName.getModule()).click();
	}

	/**
	 * This method is used to logout from the LIMS apliocation
	 */
	public void logOut() {
		logoutBtn.click();
	}

	public String getName() {
		String name = "kishore";
		return name;
	}
}

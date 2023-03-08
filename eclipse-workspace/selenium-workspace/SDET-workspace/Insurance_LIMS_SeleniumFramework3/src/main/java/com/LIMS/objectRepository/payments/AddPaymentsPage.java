package com.LIMS.objectRepository.payments;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the elements and functionalities related to add
 * payment page in LIMS application
 * 
 * @author kishore mallarapu
 *
 */
public class AddPaymentsPage {
	public WebDriver driver;
	String paymentsInformationTextFieldPartialXpath = "//input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;

	/**
	 * This method will convert partial xpath tp required element based on input
	 * 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xPath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * This construvtor will invoke the elements present in this class
	 * 
	 * @param driver
	 */
	public AddPaymentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to add new payment by taking map as an input
	 * 
	 * @param clientInformation
	 */
	public void addNewPayment(Map<String, String> clientInformation) {
		for (Entry<String, String> keyValue : clientInformation.entrySet()) {
			if (!keyValue.getValue().equals("")) {
				convertToElement(paymentsInformationTextFieldPartialXpath, keyValue.getKey())
						.sendKeys(keyValue.getValue());
			}

		}
		submitBtn.click();

	}

}

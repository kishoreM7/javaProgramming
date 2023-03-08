package com.LIMS.objectRepository.clients;

import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains all the elements and bussiness lo[gic related to edit
 * client page
 * 
 * @author kishore mallarapu
 *
 */
public class EditClientPage {
	private WebDriver driver;
	int ramNumber = new Random().nextInt();

	String clientInformationTextFieldPartialXpath = "//form/input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addClientSubmitButton;
	String name = "kishore";

	/**
	 * used to convert partial xpath to dynamic xpath and return webelement
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
 * this constructo will invoke all the elememts present in edit client page
 * @param driver
 */
	public EditClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * 
	 * @param replaceData
	 */
	public void clearElement(String replaceData) {
		WebElement ele = convertToElement(clientInformationTextFieldPartialXpath, replaceData);
		ele.clear();
	}

	/**
	 * 
	 * @param replaceData
	 * @param requiredData
	 */
	public void updateTextField(String replaceData, String requiredData) {
		WebElement ele = convertToElement(clientInformationTextFieldPartialXpath, replaceData);
		ele.sendKeys(requiredData);

	}

	/**
	 * 
	 * @param replaceData
	 * @param requiredData
	 */
	public void updateClientInformation(String replaceData, String requiredData) {
		WebElement ele = convertToElement(clientInformationTextFieldPartialXpath, replaceData);
		ele.clear();
		ele.sendKeys(requiredData);
		addClientSubmitButton.click();
	}

	/**
	 * 
	 * @param clientInformation
	 */
	/*
	 * public void editClient(Map<String, String> clientInformation) { for
	 * (Entry<String, String> keyValue : clientInformation.entrySet()) { if
	 * (!keyValue.getValue().equals("")) {
	 * convertToElement(clientInformationTextFieldPartialXpath, keyValue.getKey())
	 * .sendKeys(keyValue.getValue()); } } addClientSubmitButton.click();
	 * 
	 * }
	 */

}

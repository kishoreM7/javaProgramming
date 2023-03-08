package com.LIMS.objectRepository.clients;

import java.util.Map;


import java.util.Map.Entry;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class contains all the elementys and bussiness logic related to add
 * client page
 * 
 * @author kishore mallarapu
 *
 */
public class AddClientPage {

	private WebDriver driver;
	int ramNumber = new Random().nextInt();

	String clientInformationTextFieldPartialXpath = "//div[@class='col-md-12']/form/input[@name='%s']";
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addClientSubmitButton;

	/**
	 * This mmethod will convert partial xpath to dynamic xpath and return web
	 * element
	 * 
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToElement(String partialXpath, String replaceData) {
		String xPath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}

	@FindBy(xpath = "//div[@class='col-md-12']/form/input[@name='fileToUpload']")
	private WebElement fileUpload;

	/**
	 * This constructor will invoke the elements present in add client page
	 * 
	 * @param driver
	 */
	public AddClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * using this method we can add a new client and submit a new client will be
	 * added
	 * 
	 * @param clientInformation
	 * @param randomNumber
	 */
	public void addNewClient(Map<String, String> clientInformation, int randomNumber) {
		for (Entry<String, String> keyValue : clientInformation.entrySet()) {
			if (!(keyValue.getValue().equals("") || keyValue.getKey().equals("fileToUpload"))) {
				convertToElement(clientInformationTextFieldPartialXpath, keyValue.getKey())
						.sendKeys(keyValue.getValue() + "-" + randomNumber);
			}
		}
		fileUpload.sendKeys(clientInformation.get("fileToUpload"));

		addClientSubmitButton.click();

	}

	/*
	 * public void clickOnSubMitBtn() { addClientSubmitButton.click(); }
	 */

}

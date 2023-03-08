package com.LIMS.objectRepository.clients;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains all the elements and bussiness logic related to edit
 * client information page
 * 
 * @author kishore mallarapu
 *
 */
public class EditClientInformationPage {
	private WebDriver driver;
	String partialEditClientPartialXpath = "//input[@name='%s']";

	/**
	 * used to convert partial xpath to dynamic xpath and return webelement
	 * 
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToElement(String replaceData) {
		String xPath = String.format(partialEditClientPartialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * used to add new client takes map as an input and clicks on submit button
	 * after enteripng all the required detaild into input text fieldss
	 * 
	 * @param clientInformation
	 */
	public void addNewClient(Map<String, String> clientInformation) {
		for (Entry<String, String> keyValue : clientInformation.entrySet()) {
			if (!keyValue.getValue().equals("")) {
				convertToElement(keyValue.getKey()).sendKeys(keyValue.getValue());
			}
		}

	}

}

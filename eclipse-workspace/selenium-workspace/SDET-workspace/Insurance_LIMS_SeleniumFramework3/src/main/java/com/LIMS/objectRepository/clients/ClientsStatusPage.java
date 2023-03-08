package com.LIMS.objectRepository.clients;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements and bussiness logic related to client status
 * page
 * 
 * @author kishore mallarapu
 *
 */
public class ClientsStatusPage {
	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Edit Client']")
	private WebElement editClientLink;

	/**
	 * used to invoke the elements present in client status page
	 * 
	 * @param driver
	 */
	public ClientsStatusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * used to click on edit link which is present ipn client status page
	 */
	public void clickOneditLink() {
		editClientLink.click();
	}

}

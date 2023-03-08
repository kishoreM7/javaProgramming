package com.LIMS.objectRepository.payments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class containds all the elements and bussiness logipc related to payment
 * information page
 * 
 * @author kishore mallarapu
 *
 */
public class PaymentsInformationPage {
	private WebDriver driver;

	/**
	 * This constructor will invoke all the elements present in this page
	 * 
	 * @param driver
	 */
	public PaymentsInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='btn']")
	/**
	 * This method used to click on submit button related to add payments page
	 */
	private WebElement addPaymentButton;

	public void clickaddPaymentsBtn() {
		addPaymentButton.click();

	}

}

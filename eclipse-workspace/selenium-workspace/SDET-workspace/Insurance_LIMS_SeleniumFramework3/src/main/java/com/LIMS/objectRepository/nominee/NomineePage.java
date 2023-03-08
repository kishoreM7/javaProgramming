package com.LIMS.objectRepository.nominee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineePage {
	private WebDriver driver;
	@FindBy(xpath = "//button[@class='btn']")
	
	private WebElement addNomineeBtn;

	String addNomineeinputPartialXpath = "//input[@name='%s']";

	public NomineePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddNomineeBtn() {
		addNomineeBtn.click();

	}

}

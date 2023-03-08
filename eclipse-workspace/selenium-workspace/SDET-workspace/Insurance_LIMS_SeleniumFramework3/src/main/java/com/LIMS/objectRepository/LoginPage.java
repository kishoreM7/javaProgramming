package com.LIMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTextField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;
	@FindBy(xpath = "//button[text()='login']")
	private WebElement loginButtton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/**
 * This method is used to log in to the application
 * @param userName
 * @param password
 */
	public void loginToApplication(String userName, String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginButtton.click();

	}
}

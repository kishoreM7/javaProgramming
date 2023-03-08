package com.LIMS.objectRepository.clients;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.LIMS.genericUtility.javascriptUtility.JavaScriptUtility;

/**
 * This class contains all the elements and buossiness lo[gipc related tp client
 * information page
 * 
 * @author kishore mallarapu
 *
 */
public class ClientsInformationPage {
	private WebDriver driver;
	JavaScriptUtility sc;
	@FindBy(xpath = "//table//td[1]")
	private List<WebElement> ClientNames;

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement addClientButton;
	String editClientPartialXpath = "//tbody/tr/td[contains(text(),'%s')]/following::td[6]/a";

	/**
	 * This method will convert partial xpath to required element based on input
	 * 
	 * @param replaceData
	 * @return
	 */
	public WebElement convertToElement(String replaceData) {
		String xPath = String.format(editClientPartialXpath, replaceData);
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * This constuctor will invoke all the elements pre2sent in this class
	 * 
	 * @param driver
	 */
	public ClientsInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * used to click on add clients button which is present in clients information
	 * page
	 */
	public void clickOnAddClientButton() {
		addClientButton.click();
	}

	/**
	 * we can scroll to the reuired elemtent and click on particular element based
	 * on input a element will be generated
	 * 
	 * @param clientId
	 */
	public void scrollToElementAndClickOnEditClient(String clientId) {
		sc = new JavaScriptUtility(driver);
		WebElement clientStatus = convertToElement(clientId);
		sc.scrollUptoParticularWebElement(driver, clientStatus);
		clientStatus.click();

	}

	public ArrayList<String> printClients() {
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement list1 : ClientNames) {
			list.add(list1.getText());
		}

		return list;

	}

	/**
	 * This methos is used to check if the client is added or not
	 * 
	 * @param clientId
	 */
	public void validateClient(String clientId) {
		ArrayList<String> l = printClients();
		for (int i = 0; i <= l.size(); i++) {
			if (l.get(i).equals(clientId)) {
				System.out.println("client updated successfully");
				break;
			}

		}

	}

}

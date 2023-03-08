package com.LIMS.genericUtility.javascriptUtility;

import org.openqa.selenium.By;

/**
 * 
 * @author kishore mallarapu
 *
 */

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains generic utilities related to javascriptExecutoe
 * 
 * @author kishore mallarapu
 *
 */
public class JavaScriptUtility {
	JavascriptExecutor js;

	/**
	 * this constructor will invoke javascript executor
	 * 
	 * @param driver
	 */
	public JavaScriptUtility(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	/**
	 * This method will scroll the element for 500 units
	 * 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 500)", "");
	}

	/**
	 * This method will scroll down for 500 units
	 * 
	 * @param driver
	 * @param element
	 */

	public void scrollUptoParticularWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method will scroll up to the particular web element
	 * 
	 * @param driver
	 */

	public void scrollUptoLastOfWebpage(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	/**
	 * This method will scroll up to the last of the web page
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickUsingJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will click on particular web element
	 * 
	 * @param driver
	 * @param element
	 * @param data
	 */

	public void passDataUsingJavaScript(WebDriver driver, WebElement element, String data) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=arguments[1];", element, data);
	}

	/**
	 * This method will pass the data into text field
	 * 
	 * @param driver
	 * @param url
	 */

	public void navigateApplicationUsingJavaScript(WebDriver driver, String url) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method will navigate the application on web browser
	 * 
	 * @param driver
	 * @param element
	 */

	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);

	}

	/**
	 * This method will scroll untill a particular element
	 * 
	 * @param driver
	 */

	public void refreshWebpageUsingJavaScript(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("history.go(0)");
	}

	/**
	 * This method will refresh the web page
	 * 
	 * @param driver
	 * @return
	 */

	public Object getTitleUsingJavaScript(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		return jse.executeScript("return document.title");
	}

	/**
	 * This method will get the title of web page
	 * 
	 * @param driver
	 */

	public void getUrlUsingJavaScript(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("return document.URL");
	}

	/**
	 * This method will scroll to the screen to required location of particular
	 * element
	 * 
	 * @param driver
	 * @param clientId
	 * @param ele
	 */

	public void scrollToElement(WebDriver driver, String clientId, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		ele = driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'" + clientId + "')]/following::td[6]/a"));
		Point p = ele.getLocation();
		int x = p.getX();
		int y = p.getY();
		jse.executeScript("window.scrollBy(" + x + ", " + y + ")");

	}

	/**
	 * This method is used to scroll the page up using javascript executor
	 */
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

	/**
	 * This method is used to scroll the page up
	 */
	public void scrollDown() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	/**
	 * This method is used to click the element
	 * 
	 * @param element
	 */
	public void click(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * This method used to sendkeys to input text fields using javascript executor
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	/**
	 * This method is used to scroll the page to top of the element
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoview()", element);
	}

	/**
	 * This method is used to launch the application using javascriptexcutor
	 * 
	 * @param url
	 */
	public void launchApplication(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method is used to highlight the element
	 * 
	 * @param element
	 */
	public void highlight(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style','border: dashed red;');", element);

	}

	/**
	 * This method is used to refresh current page using javascriptExecutor
	 */

	public void refreshPage() {
		js.executeScript("history.go(0)");
	}

	/**
	 * This method is used to get text
	 */

	public void getInnerTextOfWebpage() {
		System.out.println(js.executeScript("return document.documentElement.innerText;").toString());
	}

	/**
	 * This method is used to get title of web page using javascript executor
	 */
	public void getTitleOfWebPage() {
		System.out.println(js.executeScript("return document.title;").toString());
	}

	/**
	 * This method is used to get url of the page using javascriptexecutor
	 */
	public void getUrlOfThePage() {
		System.out.println(js.executeScript("return document.URL;").toString());
	}

}

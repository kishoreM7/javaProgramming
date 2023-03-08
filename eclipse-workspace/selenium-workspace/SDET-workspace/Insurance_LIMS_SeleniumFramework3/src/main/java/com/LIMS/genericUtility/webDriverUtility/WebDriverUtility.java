package com.LIMS.genericUtility.webDriverUtility;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LIMS.genericUtility.javaUtility.JavaUtility;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains generic methods to handle webdriver
 * @author kishore mallarapu
 *
 */

public class WebDriverUtility {
	public WebDriver driver;

	/**
	 * This method will launch the browser
	 * 
	 * @param browser
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public WebDriver launchWebBrowser(String browser, String... s) throws IOException {

		switch (browser) {

		case "chrome":
			if (s.length == 1) {

				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(option);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			break;
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("enter proper key '+browser+'");
			break;
		}
		return driver;

	}

	/**
	 * This method will maximise windiow
	 * 
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the the current window
	 */
	public void minimizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * This method will get title of current web page
	 * 
	 * @param driver
	 * @return
	 */

	public String getTitleOfWebPage(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * this metnod will launch the application based on given url
	 * 
	 * @param driver
	 * @param url
	 */
	public void launchApplication(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * this method will return current url of web page
	 * 
	 * @param driver
	 * @return
	 */
	public String getUrlOfWebpage(WebDriver driver) {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * This method will open return source code of current web page
	 * 
	 * @param driver
	 * @return
	 */

	public String getSourceCodeOfWebpage(WebDriver driver) {
		String code = driver.getPageSource();
		return code;
	}

	/**
	 * This method will close the present window
	 * 
	 * @param driver
	 */

	public void close(WebDriver driver) {
		driver.close();
	}

	/**
	 * This method will close all the windows
	 * 
	 * @param driver
	 */

	public void closeAllWindow(WebDriver driver) {
		driver.quit();
	}

	/**
	 * This method will close all the window
	 * 
	 * @param driver
	 * @param width
	 * @param height
	 */

	public void setSizeOfBrowser(WebDriver driver, int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	/**
	 * This method will customize the width and height of browser
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */

	// This method will customize the x and y co-ordinate of browser

	public void setPositionOfBrowser(WebDriver driver, int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}

	/**
	 * This method will customize the x and y co-ordinate of browser
	 * 
	 * @param element
	 */

	public void clearElement(WebElement element) {
		element.clear();
	}

	/**
	 * 
	 * This method will remove the value present in web element
	 * 
	 * @param element
	 * @return
	 */

	public String getTagNameOfElement(WebElement element) {
		return element.getTagName();
	}

	/**
	 * This method will return tag name of web element
	 * 
	 * @param driver
	 */

	public void waitForPageLoad(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * This method will wait for entire page to load for 20 seconds
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * This method is use to wait for element to be visible
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This method will wait for element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * This method will wait for element to be selected
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 */

	public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	/**
	 * This method will wait for the text to be present in element
	 * 
	 * @param element
	 * @param index
	 */

	Robot r;

	public void pressEnterKey() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will take screenshot and save it in screenshot folder
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */

	
	public String getScreenShot(String testCaseName, JavaUtility javaUtility) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/page/" + testCaseName + "-" + javaUtility.getCurrentDateTime() + ".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();

	}

	/**
	 * this method will take screenshot of web page
	 * 
	 * @return
	 */
	public String getScreenShot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		return takesScreenshot.getScreenshotAs(OutputType.BASE64);

	}

	/**
	 * This method will switch to window based on partial window title
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */

	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String indWindow : allWindows) {
			String currentWinTitle = driver.switchTo().window(indWindow).getTitle();
			if (currentWinTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}

	/**
	 * This method will click on element
	 * 
	 * @param ele
	 */
	public void click(WebElement ele) {
		ele.click();

	}

	/**
	 * This method will close the window
	 * 
	 */

	public void closeWindow() {
		driver.close();
	}

}

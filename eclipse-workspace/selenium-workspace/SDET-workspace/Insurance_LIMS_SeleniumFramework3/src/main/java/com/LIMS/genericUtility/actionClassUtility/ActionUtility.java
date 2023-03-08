package com.LIMS.genericUtility.actionClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The user-facing API for emulating complex user gestures. Use this class
 * rather than using theKeyboard or Mouse directly.
 * 
 * @author kishore mallarapu
 *
 */
public class ActionUtility {
	/**
	 * This method is used to perform mousehover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform mousehover actionbased on location of elements
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */

	public void mouseHoverAction(WebDriver driver, WebElement element, int x, int y) {
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).perform();
	}

	/**
	 * This method will perform mouse hover action based on offset
	 * 
	 * @param driver
	 */

	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * /This method will perform right click randomely on webpage
	 * 
	 * @param driver
	 * @param element
	 */

	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform right click on a particular web element
	 * 
	 * @param driver
	 */

	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will perform double click randomly on web page
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform double click on particular web element
	 * 
	 * @param driver
	 */

	public void clickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.click().perform();
	}

	/**
	 * This method will click randomly on web page
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	/**
	 * This method will click on particular web element
	 * 
	 * @param driver
	 */

	public void clickAndHoldAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.clickAndHold().perform();
	}

	/**
	 * This method will click and hold randomly on web page
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	/**
	 * This method will click and hold the particular web element
	 * 
	 * @param driver
	 */

	public void releaseAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.release().perform();
	}

	/**
	 * This method will release the holded web page
	 * 
	 * @param driver
	 * @param element
	 */

	public void releaseAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.release(element).perform();
	}

	/**
	 * This method will release the holded particular web element
	 * 
	 * @param driver
	 * @param srcElement
	 * @param tarElement
	 */

	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement tarElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, tarElement).perform();
	}

	/**
	 * This method will drag and drop from source element to target element
	 * 
	 * @param driver
	 * @param srcElement
	 * @param x
	 * @param y
	 */

	public void dragAndDropByAction(WebDriver driver, WebElement srcElement, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(srcElement, x, y);
	}

}

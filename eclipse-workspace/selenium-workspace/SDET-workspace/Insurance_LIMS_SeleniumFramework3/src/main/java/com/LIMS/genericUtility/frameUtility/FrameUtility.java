package com.LIMS.genericUtility.frameUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains generic utilities related to frames
 * 
 * @author kishore mallarapu
 *
 */
public class FrameUtility {

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch to frame based on index
	 * 
	 * @param driver
	 * @param nameOrID
	 */

	public void switchToFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}

	/**
	 * This method will switch to frame based on name or id
	 * 
	 * @param driver
	 * @param element
	 */

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method will switch to frame based on web element
	 * 
	 * @param driver
	 */

	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to default frame
	 * 
	 * @param driver
	 */

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

}

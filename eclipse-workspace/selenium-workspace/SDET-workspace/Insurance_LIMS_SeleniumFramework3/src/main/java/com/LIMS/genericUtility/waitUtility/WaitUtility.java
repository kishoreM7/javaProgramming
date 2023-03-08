package com.LIMS.genericUtility.waitUtility;

import org.openqa.selenium.WebElement;

/**
 * This method
 * @author kishore mallarapu
 *
 */
public class WaitUtility {

	
	/**
	 * This method contains custom wait 
	 * 
	 * 
	 * @param pollingTime
	 * @param duration
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitTilllClick(long pollingTime, int duration, WebElement element) throws InterruptedException {
		int count = 0;
		while (count < duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(pollingTime);
				count = count + ((int) pollingTime / 1000);

			}
		}

	}
}

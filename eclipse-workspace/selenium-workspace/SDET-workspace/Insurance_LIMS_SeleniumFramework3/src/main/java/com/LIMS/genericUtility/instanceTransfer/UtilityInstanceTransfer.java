package com.LIMS.genericUtility.instanceTransfer;

import com.aventstack.extentreports.ExtentTest;

/**
 * This class contains utility related to instance transfer
 * 
 * @author kishore mallarapu
 *
 */
public class UtilityInstanceTransfer {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/**
	 * This method is used to get ExtentTest
	 * 
	 * @return
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * This method is used to set ExtentTest
	 * 
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest.set(setExtentTest);
	}

}

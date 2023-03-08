package com.LIMS.Listener;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.LIMS.baseClass.ConfigurationClass;


public class ListenerImplementation implements ITestListener, IClassListener, ISuiteListener {

	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass > IClassListener");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass  >IClassListener");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart  > itest");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess  > itest");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// ConfigurationClass.class.cast(result.getMethod().getInstance()).

	//	System.out.println("onTestFailure  > itest");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped  > itest");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage  > itest");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart  > itest");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish  > itest");

	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart  >suite");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish  >suite");

	}

}

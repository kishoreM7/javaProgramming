package LIMS.ims.pratice;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPractice {
	@BeforeSuite
	public void beforeSuitSetUp() {
		System.out.println("beforeSuitSetUp");
	}

	@BeforeClass
	public void beforeClassSetup() {
		System.out.println("before class");

	}

	@BeforeMethod
	public void beforeMethodSetUp() {
		System.out.println("beforeMethodSetUp");
	}

	@BeforeTest
	public void beforeTestSetup() {

		System.out.println("beforeTestSetup");
	}

	@Test
	public void test() {
		Assert.fail();
		System.out.println("test");

	}

	@Test
	public void test1() {
		System.out.println("test1");

	}

	@Test()

	public void test2() {

		System.out.println("test2");

	}

	@AfterSuite
	public void afterSuitTearDown() {
		System.out.println("afterSuit");
	}

	@AfterClass
	public void afterClassTearDown() {
		System.out.println("afterClass");

	}

	@AfterMethod
	public void afterMethodTearDown() {
		System.out.println("afterMethod");
	}

	@AfterTest
	public void afterTestTearDown() {
		System.out.println("afterTest");
	}

}

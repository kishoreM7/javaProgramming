package LIMS.ims.pratice;

import org.testng.annotations.Test;

public class TestNGPractice2 {
	

	@Test(groups="sanity")
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(groups = "reg")
	public void test2() {
		System.out.println("test2");
	}

	
	@Test
	public void test3() {
		System.out.println("tes3");
	}

	
	@Test
	public void test4() {
		System.out.println("test4");
	}


}

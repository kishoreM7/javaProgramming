package LIMS.ims.pratice.listener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.LIMS.baseClass.ConfigurationClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ITestPractice extends ConfigurationClass{
	@Test
	public void rest() {
		System.out.println("rest code");
		
		Assert.fail();
	}

}

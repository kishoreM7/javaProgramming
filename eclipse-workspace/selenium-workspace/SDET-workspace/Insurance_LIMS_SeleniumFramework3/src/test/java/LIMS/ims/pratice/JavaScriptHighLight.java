package LIMS.ims.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LIMS.genericUtility.javascriptUtility.JavaScriptUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptHighLight {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavaScriptUtility javaScriptUtility = new JavaScriptUtility(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		WebElement ele = driver.findElement(By.xpath("//input[@name='email']"));
		javaScriptUtility.highlight(ele);
		javaScriptUtility.scrollDown();
	}

}

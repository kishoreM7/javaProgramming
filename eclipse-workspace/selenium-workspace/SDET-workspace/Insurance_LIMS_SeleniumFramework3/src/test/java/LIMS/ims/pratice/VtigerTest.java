package LIMS.ims.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerTest {
	public static void main(String[]args)
	{
	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.className("hasDatepicker")).click();
		String month=driver.findElement(By.className("ui-datepicker-month")).getText();
		String year=driver.findElement(By.className("ui-datepicker-year")).getText();
		while(!(month.equals("December") && year.equals("1994")))
		{
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			 month=driver.findElement(By.className("ui-datepicker-month")).getText();
			 year=driver.findElement(By.className("ui-datepicker-year")).getText();
			
		}
		driver.findElement(By.linkText("16")).click();
	}

}

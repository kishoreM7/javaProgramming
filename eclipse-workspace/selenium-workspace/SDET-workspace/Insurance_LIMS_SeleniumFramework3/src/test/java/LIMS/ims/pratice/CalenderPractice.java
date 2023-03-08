package LIMS.ims.pratice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPractice {
	public static void main(String[] args) {
		String reqYear = "2023";
		String reqMonth = "november";
		String reqDAte = "15";
		String returnDate = "25";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.united.com/en/us");
		driver.findElement(By.id("DepartDate")).click();
		String month = driver
				.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1']/strong)[2]"))
				.getText();
		System.out.println(month);
		month.trim();
		String defaultYear = month.split(" ")[1];
		String defaultMonth = month.split(" ")[0];
		System.out.println(defaultYear);
		System.out.println(defaultMonth);
		// reqMonth =
		// DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(defaultMonth)
		// .get(ChronoField.MONTH_OF_YEAR);
		int defaultYearr = Integer.parseInt(defaultYear);

	}

}

package LIMS.ims.pratice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.LIMS.genericUtility.enums.AutoConstants;
import com.LIMS.genericUtility.enums.PropertiesFile;
import com.LIMS.genericUtility.propertyUtility.PropertyUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://open.spotify.com/");

	}

}

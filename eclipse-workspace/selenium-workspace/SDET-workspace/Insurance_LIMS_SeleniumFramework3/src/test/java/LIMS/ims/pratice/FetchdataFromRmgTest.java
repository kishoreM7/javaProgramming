package LIMS.ims.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchdataFromRmgTest {

	public static void main(String[]args) 
	{
		String projectname="Selenium12"+new Random().nextInt(1000);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectname);
		driver.findElement(By.name("teamSize")).click();
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("smruti");
		WebElement dropdown=driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name='status']"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for(WebElement alllist:list)
		{
			String project=alllist.getText();
			if(project.equals(projectname))
			{
				System.out.println("Created successfully");
			}
		}
		
		Connection con=null;
		try {
			Driver dbDriver;
			dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);
			



			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement sta=con.createStatement();
			ResultSet res=sta.executeQuery("select * from project");
			while(res.next())
			{
				String projectname2=res.getString("project_name");
				if(projectname2.equals(projectname))
				{
					System.out.println("Data is present in database");
				}

			}

		}
		catch (Exception e) {
		
		}

		finally 

		{

			try {
				con.close();
				System.out.println("connection closed");
				driver.quit();
			} catch (SQLException e) {

			}
			
		}

	}



}

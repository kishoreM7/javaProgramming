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


import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetechthedataFromRmgserver {

	public static void main(String[] args) {
		String p_id="TY_PROJ_"+new Random().nextInt(1000);
		String actprojectName="Selenium12"+new Random().nextInt(1000);
		Connection con=null;
		try {
			Driver dbDriver;
			dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);

			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement sta=con.createStatement();
			  int res=sta.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size)values('"+p_id+"','smruti','08/06/1994','"+actprojectName+"','craeted',3);");
			if(res==1)
			{
				
					System.out.println("Data added sucessfully");
				

			}
			ResultSet res2 = sta.executeQuery("select * from project");
			while(res2.next())
			{
				String projectName = res2.getString("project_name");
				if(projectName.equals(actprojectName)) {
					System.out.println("data present in database-->  "+projectName);
					break;
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
			
			} catch (SQLException e) {

			}
			
		}
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> list=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for(WebElement alllist:list)
		{
			String project=alllist.getText();
			if(project.equals(actprojectName))
			{
				System.out.println("Created successfully");
				break;
			}
		}

	}

}

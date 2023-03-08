package LIMS.ims.pratice;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	public static void main(String[]args) throws SQLException
	{
	   //step1=create instance for driver->register driver to jdk
	   Driver dbDriver=new Driver();
	   DriverManager.registerDriver(dbDriver);
	   //step2=get connection
	   Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
	   //step3=create statement
	   Statement statement=connection.createStatement();
	   //step4=execute query
	   ResultSet result=statement.executeQuery("select * from employee");
	  //step5=iterate data and verify or fetch
	   while(result.next())
		  {
		   String id = result.getString("emp_name");
		   System.out.println(id);
			 
			 		  }
		  //step6=close
		  connection.close();
		 
	}

}

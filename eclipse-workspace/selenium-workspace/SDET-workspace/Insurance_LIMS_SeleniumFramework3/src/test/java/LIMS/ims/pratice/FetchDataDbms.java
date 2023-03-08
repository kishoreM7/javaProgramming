package LIMS.ims.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataDbms 
  {
	static Connection con=null;
	public static void main(String[] args)  
	   {
		 
		try {
			Driver dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
		    Statement sta=con.createStatement();
		    ResultSet res=sta.executeQuery("select * from employee");
		    if(res.next())
		    {
		    	int id=res.getInt("emp_id");
		    	System.out.println(id);
		    	String name=res.getString("emp_name");
		    	System.out.println(name);
		    	
            }
		   
	}
		catch (SQLException e) 
		    {
		
		    System.out.println("Sql exception");
	        }
	
		finally 
		    
		{
			try
			{
			con.close();
			}
			catch(Exception e)
			{
		      System.out.println("connection closed");
	     	}
		    
		}

	}
	
}




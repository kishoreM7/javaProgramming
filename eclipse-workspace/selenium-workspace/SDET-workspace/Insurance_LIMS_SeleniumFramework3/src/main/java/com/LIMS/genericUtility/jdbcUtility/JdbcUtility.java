package com.LIMS.genericUtility.jdbcUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author kishore mallarapu
 *
 */
public class JdbcUtility {
	Connection connection;
	Statement statement;

	/**
	 * this constructor is used to open database connection and initialize
	 * connection and statement
	 * 
	 * @param dbUrl
	 * @param userName
	 * @param password
	 * @throws SQLException
	 */
	public JdbcUtility(String dbUrl, String userName, String password) throws SQLException {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		connection = DriverManager.getConnection(dbUrl, userName, password);
		statement = connection.createStatement();
	}

	/**
	 * This query is used to fetch data from database through DQL actions
	 * 
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDatabase(String query, String columnName) throws SQLException {
		List<String> databaseList = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			databaseList.add(result.getString(columnName));
		}
		return databaseList;
	}

	/**
	 * This method is used to validate data from database
	 * 
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public boolean validateDataInDatabase(String query, String columnName, String expData) throws SQLException {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean flag = false;
		for (String actData : list) {
			if (actData.equalsIgnoreCase(expData)) {
				flag = true;
				break;

			}

		}
		return flag;

	}

	/**
	 * This method is used to insert and update data into database
	 * 
	 * @param query
	 * @throws SQLException
	 */
	public void setDataIntoDatabase(String query) throws SQLException {
		int result = statement.executeUpdate(query);
		if (result >= 1) {
			System.out.println("data entered or modified successfully");
		}

	}

	/**
	 * This method is used close database connection
	 */
	public void closeDatabaseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("while closing database we got exception");
		}
	}

}

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection connection;
	
	public static Connection initializedb() throws ClassNotFoundException,SQLException {
		   
		
		if (connection == null || connection.isClosed()) {
			    
			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url="jdbc:sqlserver://localhost:1433;databaseName=Restaurant";
			    connection=DriverManager.getConnection(url,"employee","6328");
			 
		} 
			
			    return connection; 
	}
}

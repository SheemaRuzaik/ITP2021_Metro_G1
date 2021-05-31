package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	

	
		private static String url ="jdbc:mysql://localhost:3306/inventory_asset_management";
		private static String userName ="root";
		private static String password ="sheema123";
		
		
		private static Connection con;
		
		public static Connection initializedb() throws ClassNotFoundException,SQLException {
			try {

				//registering database connection
				Class.forName("com.mysql.jdbc.Driver");

				//opening a connection
				con=DriverManager.getConnection(url,userName,password);
				
			}catch(Exception e){
				System.out.println("Database connection is not succesful");
			}
			return con; 
		}

}

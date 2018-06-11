package com.demoservlet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	
	public static Connection getSqlConnection() throws Exception
	{
		
//		
		Class.forName("com.mysql.jdbc.Driver");
		
		return 	DriverManager.getConnection("jdbc:mysql://localhost:3306/registraion", "root", "");
		
	}
}

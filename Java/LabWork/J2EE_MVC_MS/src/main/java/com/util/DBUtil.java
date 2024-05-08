package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	Connection cn=null;
	public Connection getConnectionData()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root","");
			System.out.println("Connection established...");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}

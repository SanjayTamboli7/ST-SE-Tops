package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	Connection cn=null;
	public Connection getConnectionData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crm","root","");
			System.out.println("DB connection established");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}

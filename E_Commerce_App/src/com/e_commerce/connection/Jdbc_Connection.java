package com.e_commerce.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_Connection {

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce_scema","root","Kishor@2346");
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 return connection;
	}
	
}

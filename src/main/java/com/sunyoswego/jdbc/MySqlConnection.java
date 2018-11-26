package com.sunyoswego.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	private static Connection con;

	public static Connection getConnection() {
		try {
			if (con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://host:3306/dbname", "user",
						"password");
			}
	
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}

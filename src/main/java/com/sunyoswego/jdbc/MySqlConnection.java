package com.sunyoswego.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class MySqlConnection {

	public static void Connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://hostname:3306/DBname", "userName", "password");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vehicles");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getDouble(4) + "\t" + rs.getDouble(5) + "\t" + rs.getString(6) + "\t" + rs.getInt(7) + "\t"
						+ rs.getString(8) + "\t" + rs.getString(9) + "\t" + rs.getInt(10) + "\t" + rs.getInt(11) + "\t"
						+ rs.getInt(12) + "\t" + rs.getString(13) + "\t" + rs.getString(14) + "\t" + rs.getString(15)
						+ "\n");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

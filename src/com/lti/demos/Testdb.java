package com.lti.demos;

import java.sql.Connection;

import java.sql.SQLException;

import java.sql.DriverManager;


public class Testdb {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";	// orcl or XE or OSE		
		Connection  conn=DriverManager.getConnection(url,"hr","hr");		
		if (conn != null) 
		{
			System.out.println("Connected");
			conn.close();
		}	

	}

}

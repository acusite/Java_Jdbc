package com.lti.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

	
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";	// orcl or XE or OSE		
		 conn=DriverManager.getConnection(url,"hr","hr");		
		if (conn != null) 
		{
			System.out.println("Connected");
			
		}	
		
		
		Statement stm=conn.createStatement();
		
		ResultSet rs=stm.executeQuery("Select * from Products");
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String pname=rs.getString(2);
			float cost=rs.getFloat(3);
			System.out.println(pname);
		}
		}
		
		catch(SQLException e) {
			System.out.println(" error"+e);
		}
		
		finally {
			conn.close();
		}
	}

}

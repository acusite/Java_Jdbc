package com.lti.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//executeQuery ---> select quries --> return result set

// executeUpdate -->DML OPerations --> returns how many rows
public class JdbcDemo2 {

	public static void main(String[] args) throws SQLException{
		Connection conn=null;
		try {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";	// orcl or XE or OSE		
		 conn=DriverManager.getConnection(url,"hr","hr");		
		 Statement stm=conn.createStatement();
		 int rows=stm.executeUpdate("insert into Products values(104 ,'Rishi',1000)");
		System.out.println(rows +" added");
		ResultSet rs=stm.executeQuery("Select * from Products");
		
		while(rs.next()) {
			int id=rs.getInt(1);
			String pname=rs.getString(2);
			float cost=rs.getFloat(3);
			System.out.println(pname);
		}
		}
		
		catch(SQLException e) {
			System.out.println(e);
		}
		
		finally {
			conn.close();
		}

	}

}

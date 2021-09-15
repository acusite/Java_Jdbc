package com.lti.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo4 {
	
	public static void main(String[] args)  throws SQLException {
		Connection conn=null;
		try {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		// orcl or XE or OSE		
		//preparestatements are faster they are pre compiled
		 Scanner sc=new Scanner(System.in);
		int a= sc.nextInt();
		String str= sc.next();
		float f= sc.nextFloat();
		 conn=DriverManager.getConnection(url,"hr","hr");		
		 PreparedStatement psmt=conn.prepareStatement("insert into products values (?,?,?)");
		 psmt.setInt(1, a);
		 psmt.setString(2, str);
		 psmt.setFloat(3, f);
		 
		int rows= psmt.executeUpdate();
		 System.out.println(rows+" added");
		}
		
		catch(SQLException e) {
			System.out.println(e);
		}
		
		finally {
			conn.close();
		}



	}

}

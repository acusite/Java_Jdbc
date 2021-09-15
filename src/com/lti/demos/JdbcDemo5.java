package com.lti.demos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// we can call predefines procedures or functions from database
//no neeed to fetch multiple records in java and process then
//performance will be low
//call directly pro/function  from db -->they get executed on the db
// which return value back in java
public class JdbcDemo5 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		 CallableStatement cstmt=null;
		try {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";	// orcl or XE or OSE		
		 conn=DriverManager.getConnection(url,"hr","hr");		
		 cstmt=conn.prepareCall("{call getProductName(?,?)}");
		 cstmt.setInt(1, 1112);
		 cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
		System.out.println( cstmt.executeUpdate());
		 String str=cstmt.getString(2);
		 
		 System.out.print(str);
		 		}
		
		catch(SQLException e) {
			System.out.println(e);
		}
		
		finally {
			conn.close();
		}

	}

}

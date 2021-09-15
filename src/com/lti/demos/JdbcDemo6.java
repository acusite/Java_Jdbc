package com.lti.demos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo6 {


	public static void main(String[] args)  throws SQLException{
		Connection conn=null;
		try {
		String url = "jdbc:oracle:thin:@localhost:1521/XE";	// orcl or XE or OSE		
		 conn=DriverManager.getConnection(url,"hr","hr");		
		 Statement stmt = conn.createStatement();
			String query = "select * from Products";
			ResultSet rs = stmt.executeQuery(query);

			ResultSetMetaData rsmd = rs.getMetaData();
	 
			System.out.println("no of columns in the table= " + rsmd.getColumnCount());
			System.out.println("Name of the first column " + rsmd.getColumnName(1));
			System.out.println("Type of the second column " + rsmd.getColumnTypeName(2));
			System.out.println("No of characters in 3rd column " + rsmd.getColumnDisplaySize(2));

			DatabaseMetaData dma = conn.getMetaData();
				      
								System.out.println("\n  connected to "+ dma.getURL());
								System.out.println(" driver "+ dma.getDriverName());
								System.out.println(" version "+ dma.getDatabaseProductName());  
				                System.out.println(" version "+ dma.getUserName()); 

		}
		
		catch(SQLException e) {
			System.out.println(" error"+e);
		}
		
		finally {
			conn.close();
		}


	}

}

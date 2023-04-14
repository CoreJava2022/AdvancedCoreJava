package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStmt {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection("jdbc:sqlserver://localhost:65535/empdatabase;user=sa;password=");
		System.out.println("connection created");
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(con!=null) {
				con.close();
			}else if(stmt!=null) {
				stmt.close();
			}else if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	}

}

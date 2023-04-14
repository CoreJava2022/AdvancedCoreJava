package com.jdbcexample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatement {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase","root","System");
		stmt=con.createStatement();
		String s="SELECT * FROM EMPLOYEE";
		rs=stmt.executeQuery(s);
		while(rs.next()) {
			int id =rs.getInt("ID");
			String name=rs.getString("NAME");
			String age = rs.getString("Age");
			
			 System.out.print("ID: " + id);
             System.out.print(", Name: " + name);
             System.out.println(", Age: " + age);
		}
		
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

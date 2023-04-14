package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	public class OracleConnection {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="System";
		String pwd="System";
			Connection con=DriverManager.getConnection(url,userName,pwd);
			Statement stmt=con.createStatement();
			String s="SELECT * FROM EMPLOYEE";
			ResultSet rs=stmt.executeQuery(s);
			while(rs.next()) {
				int empId =rs.getInt("EmpId");
				System.out.println("ID: " + empId);
	            
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrcleConnection {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userName="System";
		String pwd="System";
		Connection con=null;
		Statement stmt = null;
			ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(url,userName,pwd);
			stmt=con.createStatement();
			String s="SELECT * FROM EMPLOYEE";
			rs=stmt.executeQuery(s);
			while(rs.next()) {
				int empId =rs.getInt("EmpId");
				String firstName=rs.getString("FirstName");
				String lastName = rs.getString("LastName");
			    String email =rs.getString("Email");
			    String phoneNo = rs.getString("PhoneNo");
			   int salary = rs.getInt("Salary");				
				 System.out.println("ID: " + empId);
	             System.out.println("Name: " + firstName);
	             System.out.println("lastName: " + lastName);
	             System.out.println("email: " + email);
	             System.out.println("phoneNo: " + phoneNo);
	             System.out.println("salary: " + salary);
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

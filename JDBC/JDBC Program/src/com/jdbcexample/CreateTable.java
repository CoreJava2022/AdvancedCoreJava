package com.jdbcexample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase","root","System");
			
			stmt =con.createStatement();
			String sql="CREATE TABLE Employee"+"(ID INT PRIMARY KEY NOT NULL, "+" NAME TEXT NOT NULL," + " AGE INT NOT NULL )";
			stmt.executeUpdate(sql);
			System.out.println("table created.............");
			
		} catch(SQLException e){
			 e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        	try {
        	if(con!=null) {
					con.close();
        	}else if(stmt!=null) {
        		stmt.close();
        	}else if(rs!=null) {
        		rs.close();
        	}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	}
}

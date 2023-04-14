package com.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord {

	public static void main(String[] args) {
		Connection con= null;
		PreparedStatement stmt=null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newdatabase","root","System");
			con.createStatement();
			 System.out.print("Enter ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();
	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();
	            System.out.print("Enter Age: ");
	            int age = sc.nextInt();
			String s="INSERT INTO Employee (ID, NAME, AGE) VALUES (?, ?, ?)";
			stmt = con.prepareStatement(s);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.executeUpdate();
            System.out.println("recod inserted..");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}

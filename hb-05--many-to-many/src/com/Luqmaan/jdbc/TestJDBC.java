package com.Luqmaan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezome=UTC ";
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("Connecting to database..");
			
			Connection myCon = DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("Connection successfull");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

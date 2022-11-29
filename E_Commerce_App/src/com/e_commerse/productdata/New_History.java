package com.e_commerse.productdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.e_commerce.connection.Jdbc_Connection;

public class New_History {
	 static Connection con = null;
	//public static void main(String[] args) throws Exception {
	 public void New_History1() throws Exception {
		Jdbc_Connection jdbc_con = new Jdbc_Connection();
		con=jdbc_con.getConnection();
		
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Select the user which u wants to see Purchase detail");
		 
		 String Username = sc.next();
	
		PreparedStatement pres9 =con.prepareStatement("select * from cart where username='"+Username+"' ");
		ResultSet rs29 = pres9.executeQuery(); 
		 while(rs29.next()) {
			 System.out.println("product name :"+rs29.getString(1));
			 System.out.println("product price :"+rs29.getInt(2));
			 System.out.println("user name :"+rs29.getString(3));
			 System.out.println("============================");
		 }
	}

}

package com.e_commerse.productdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.e_commerce.connection.Jdbc_Connection;

public class Admin_should_see_entire_register_user {
	static Connection con =null ;

 //public  static void main(String args[]) throws SQLException {
	 public void Admin_should_see_entire_register_user_list() {
	 try {
			Jdbc_Connection jdbc_con = new Jdbc_Connection();
			con=jdbc_con.getConnection();
			
			
	PreparedStatement pres =con.prepareStatement("select * from e_commerce_tab ");
 ResultSet rs = pres.executeQuery();
 while(rs.next()) {
 	
	 System.out.println("Username or User is  : "+ rs.getString(1)); 
	  System.out.println("pass is  : "+ rs.getString(2));
	  System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
 }
 
	
} catch (Exception e) {
	  e.printStackTrace();
}
// regi_display =======================================================================================
 
  }
  }	
 
	 


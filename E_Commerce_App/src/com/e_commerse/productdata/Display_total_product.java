package com.e_commerse.productdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.e_commerce.connection.Jdbc_Connection;

public class Display_total_product {
	static Connection con =null ;
 public void display() {
	 Jdbc_Connection jdbc_con = new Jdbc_Connection();
		con=jdbc_con.getConnection();
	 try {
			PreparedStatement prepareStatement1 = con.prepareStatement("select * from product ");
		 ResultSet set = prepareStatement1.executeQuery();
		  
		 
		    while(set.next()) {
		  	  //System.out.println("product_id is : "+ set.getInt(1));
			  System.out.println("product_description is  : "+ set.getString(2)); 
			  System.out.println("product_price is  : "+ set.getString(3));
			  System.out.println("product_name/brand is  :  "+ set.getString(4));
			  //System.out.println("product_quantity is  : "+ set.getString(5));
			  System.out.println("====================================================================");
		  }
		   
			prepareStatement1.close();
		    } catch (Exception e) {
			  e.printStackTrace();
		    }
	 
	 
	 
 }
}

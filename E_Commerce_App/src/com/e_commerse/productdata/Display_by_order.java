package com.e_commerse.productdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.e_commerce.connection.Jdbc_Connection;

public class Display_by_order {
	static Connection con =null ;
	public void Display_by_ordermethod() {
		try {
			Jdbc_Connection jdbc_con = new Jdbc_Connection();
			con=jdbc_con.getConnection();
			
	PreparedStatement pres =con.prepareStatement("select * from product order by product_name Asc");
    ResultSet rs = pres.executeQuery();
    System.out.println("========================== Order by assending ==========================================");
    while(rs.next()) {
    	
    	 System.out.println("product_description is  : "+ rs.getString(2)); 
		  System.out.println("product_price is  : "+ rs.getString(3));
		System.out.println("Product_name/brand is  :"+rs.getString(4));
		 System.out.println("product_quantity is  : "+ rs.getString(5));
		 System.out.println("====================================================================");
		
    }
		
		con.close();
		pres.close();
		
		}catch (Exception e) {
	}
}
}

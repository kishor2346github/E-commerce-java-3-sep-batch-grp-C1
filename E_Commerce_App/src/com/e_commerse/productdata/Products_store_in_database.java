package com.e_commerse.productdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import com.e_commerce.connection.Jdbc_Connection ;

public class Products_store_in_database {
	static Connection con =null ;
	public static void main(String[] args){
	 Products_store_in_database  ps = new  Products_store_in_database();
	 ps.products_store_in_cart_database("LG",400,"kishor");
	}
	public void products_store_in_cart_database(String productname,int productprice,String username) {
		//LinkedList ls = new LinkedList();
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Select products u want to buy :");
		int no = sc.nextInt();
     for(int l = 0; l<no ;l++) 
		{
		System.out.println("Select product :");
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		String product_Name1 =sc.next()	;
		System.out.println("Select gmail :");
		String gmail =sc.next()	;
		*/
		Jdbc_Connection jdbc_con = new Jdbc_Connection();
		con=jdbc_con.getConnection();
		
		
		//taking input from user to add a cart
		try {
			PreparedStatement prepareStatement = con.prepareStatement("insert into cart (productname,productprice,username) values(?,?,?)");
			prepareStatement.setString(1, productname);
			prepareStatement.setInt(2, productprice);
			//prepareStatement.setString(3, product_description);
			prepareStatement.setString(3, username);
			int  j =prepareStatement.executeUpdate();
			System.out.println("done"+j);
			
			//con.close();
			prepareStatement.close();
			    } catch (Exception e) {
			  e.printStackTrace();
			    }
		//===============================================================================================//
		// printing product which was user is added into the cart 
		/*try {
			PreparedStatement prepareStatement1 = con.prepareStatement("select * from cart where productname='"+product_Name1+"'");
		 ResultSet set = prepareStatement1.executeQuery();
		  
		    while(set.next()) {
		  	  System.out.println("product_name/brand  is : "+ set.getString(1));
			  System.out.println("product_price is  : "+ set.getString(2)); 
		  }
		   
			prepareStatement1.close();
		    } catch (Exception e) {
			  e.printStackTrace();
		    }
		System.out.println();
		}*/
     
		//===============================================================================================//
		
		// printing sum of all product which is  added to cart
		try {
		    PreparedStatement prepareStatement12 = con.prepareStatement("select sum(productprice) from cart where username = '"+username+"'");
		    ResultSet set1 = prepareStatement12.executeQuery();
		    while(set1.next()) {
		    	  System.out.println("All product_price is  : "+ set1.getString(1)); 
		    }
				con.close();
				prepareStatement12.close();
			    } catch (Exception e) {
				  e.printStackTrace();
			    }
			 		//===============================================================================================//
		/*try {
		    PreparedStatement prepareStatement12 = con.prepareStatement("update product set product_quantity ='"+--product_quantity+"' where product_name = '"+product_Name1+"'");
		    ResultSet set1 = prepareStatement12.executeQuery();
		    while(set1.next()) {
		    	  System.out.println("All product_price is  : "+ set1.getString(1)); 
		    }
				con.close();
				prepareStatement12.close();
			    } catch (Exception e) {
				  e.printStackTrace();
			    }
		/*
		    System.out.println("Select which u want to remove from cart");
		    String remove =sc.next()	;
		    if(remove.equals(set.getString(1))) {
		    PreparedStatement prepareStatement1 = con.prepareStatement("delete  from cart where productname ='"+remove+"'");
		    int  k =prepareStatement.executeUpdate();
			System.out.println("done"+k);and productprice='"+product_price1+"'
		    }*/
		  
			
	}
}

/* public void sign_upDetails() throws SQLException {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter product_id : ");
	int product_id =sc.nextInt();
	System.out.println("Enter product_description : ");
	String product_description =sc.next();
	System.out.println("Enter product_price : ");
	String product_price =sc.next();
	System.out.println("Enter product_name : ");
	String product_name =sc.next();
	System.out.println("Enter product_quality : ");
	String product_quality =sc.next();
	
	Products_store_in_database(product_id,product_description,product_price,product_name,product_quality);
	System.out.println("**************##########*************");
	sc.close();
}*/

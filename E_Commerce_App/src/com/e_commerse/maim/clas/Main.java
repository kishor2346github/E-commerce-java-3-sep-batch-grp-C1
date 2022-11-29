package com.e_commerse.maim.clas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.e_commerce.connection.Jdbc_Connection;
import com.e_commerece.sign_up.user.Sign_in;
import com.e_commerece.sign_up.user.Sign_up;
import com.e_commerse.productdata.Admin_should_see_entire_register_user;
import com.e_commerse.productdata.Check_out_product_from_cart;
import com.e_commerse.productdata.Display_by_order;
import com.e_commerse.productdata.Display_total_product;
import com.e_commerse.productdata.New_History;
import com.e_commerse.productdata.Products_store_in_database;

public class Main {
static Connection con =null;

	public static void main(String[] args) throws Exception {
		System.out.println("************Welcome to ONLIN SHOPPING****************");
		System.out.println();
		System.out.println("Please Select");
		System.out.println();
		System.out.println("Register             OR                   Sign_in                       Admin_login");
		System.out.println();
		Scanner sc = new Scanner(System.in);
	    Sign_in h = new Sign_in();
	    Sign_up sign_up = new Sign_up();
		String user =sc.next();
		String data =user;
		switch(data) {
		
		case "Register" : 
		
		  sign_up.sign_upDetails();
		  //h.match_signIn_data();
		  
		 break;
		
		case "sign_in":
		       
			System.out.println("Gmail : ");
			  String gmails =sc.next();
			  System.out.println("Password : ");
			  String pass1 =sc.next();
			  
			     Jdbc_Connection jdbc_conn = new Jdbc_Connection();
			     con =jdbc_conn.getConnection();
			
				  PreparedStatement prepareStatement = con.prepareStatement("select * from e_commerce_tab where gmail='"+gmails+"'and pass='"+pass1+"'");
				  ResultSet set = prepareStatement.executeQuery();
				  
				    while(set.next()) {
				    	
					  if (gmails.equals( set.getString(1)) & pass1.equals(set.getString(2))) {
	
					  System.out.println("gmail is : "+ set.getString(1));
					  System.out.println("pass is  : "+ set.getString(2));
					  }
				    }
					  
					   System.out.println("==============' Welcome to Home page '=============");
					   
					   
					  Display_total_product ds = new Display_total_product();
						ds.display();
					  
					  System.out.println("Please Select \n 1.Select  product for Buy \n 2. Select  product for Buy with order asc");
		                    int input  = sc.nextInt();
						    int select = input;
						
	           if(select==1) {
						System.out.println("Select number of products u want to buy :");
						int no1 = sc.nextInt();
				     for(int l = 0; l<no1 ;l++) 
						{
						System.out.println("Select product :");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
						String product_Name1 =sc.next()	;
						System.out.println("Select product_price :");
						int productprice =sc.nextInt()	;
						String username=gmails;
						PreparedStatement prepareStatement1 = con.prepareStatement("select * from product where product_name='"+product_Name1+"'and product_price='"+productprice+"'");
						ResultSet set1 = prepareStatement1.executeQuery();
						while(set1.next()) {
						if (product_Name1.equals( set1.getString(4)) & productprice==(set1.getInt(3))) {
						 Products_store_in_database  ps = new  Products_store_in_database();
						 ps.products_store_in_cart_database(product_Name1,productprice,username);
						
						System.out.println("Select products u want to delet : 1.yes ");
						int no12 = sc.nextInt();
						 if(select==1) 	{
					
				        Check_out_product_from_cart f = new Check_out_product_from_cart();
						f.delet_out();
						break;
						 }
						}
						}
						}
	           }
				     //by with order
					     if(select==2) {
			    Display_by_order ord = new Display_by_order();
                ord.Display_by_ordermethod();
                   
                System.out.println("Please Select \n 1.Select  product for Buy ");
                int input1  = sc.nextInt();
			    int select1 = input1;
			
            if(select1==1) {
			System.out.println("Select number of  products u want to buy :");
			int no11 = sc.nextInt();
	        for(int l = 0; l<no11 ;l++) 
			{
			System.out.println("Select product :");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
			String product_Name16 =sc.next()	;
			System.out.println("Select product_price :");
			int productprice16 =sc.nextInt()	;
			String username1=gmails;
			PreparedStatement prepareStatement16 = con.prepareStatement("select * from product where product_name='"+product_Name16+"'and product_price='"+productprice16+"'");
			ResultSet set16 = prepareStatement16.executeQuery();
			while(set16.next()) {
			if (product_Name16.equals( set16.getString(4)) & productprice16==(set16.getInt(3))) {
			 Products_store_in_database  ps = new  Products_store_in_database();
			 ps.products_store_in_cart_database(product_Name16,productprice16,username1);
			
			
			System.out.println("Select products u want to delet : 1.yes ");
			int no12 = sc.nextInt();
			 if(select1==1) 	{
		
	        Check_out_product_from_cart f = new Check_out_product_from_cart();
			f.delet_out();
			break;
			 }
			 }
			}
			}
			}  
				  }break;
	           
				    
		case "Admin_login": 
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Gmail for admin : ");
			  String gmails_admin =sc1.next();
			  System.out.println("Password : ");
			  String pass1_admin =sc1.next();
			  
			     Jdbc_Connection jdbc2_conn = new Jdbc_Connection();
			     con =jdbc2_conn.getConnection();
			
				  PreparedStatement prepareStatement78 = con.prepareStatement("select * from admin_login where Admin_username='"+gmails_admin+"'and Admin_pass='"+pass1_admin+"'");
				  ResultSet set78 = prepareStatement78.executeQuery();
				  
				    while(set78.next()) {
				    	
					  if (gmails_admin.equals( set78.getString(1)) & pass1_admin.equals(set78.getString(2))){
						 
				     
					  System.out.println("gmail is : "+ set78.getString(1));
					  System.out.println("pass is  : "+ set78.getString(2));
					  
					   System.out.println("==============' Welcome to Admin_GARAGE '=============");
					   System.out.println();
					  }
				    }
				    Display_total_product ds1 = new Display_total_product();
					ds1.display();
					  New_History nh = new New_History();
				    System.out.println("Please Select \n 1.Displya List of product by order \n 2. Show all register user list \n 3.Search history of user)");
                    int input1  = sc1.nextInt();
				    int select1 = input1;
				    switch(select1) {
				    case 1 :
				   // Display_total_product ds = new Display_total_product();
					//ds1.display();
				    	  Display_by_order ord = new Display_by_order();
				    	  ord.Display_by_ordermethod();
					break;
				    case 2:
			       Admin_should_see_entire_register_user reg = new Admin_should_see_entire_register_user();
			       reg.Admin_should_see_entire_register_user_list();
			       nh.New_History1();
			       break;
			       
				    case 3:
			     
			       nh.New_History1();
			       break;
				    }
		
		
		}
	}  
}
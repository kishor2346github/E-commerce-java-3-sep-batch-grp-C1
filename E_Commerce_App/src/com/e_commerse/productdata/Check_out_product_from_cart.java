package com.e_commerse.productdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.e_commerce.connection.Jdbc_Connection;

public class Check_out_product_from_cart {
	
	public static void main(String[] args) {
		
	}

	static Connection con =null ;
	public void delet_out() {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Select no of products u want to remove from cart :");
		
			
			int no = sc.nextInt();
		     for(int l = 0; l<no ;l++) 
				{
		    	 
				System.out.println("Select product u want to remove :");
				String product_delete =sc.next()	;
			Jdbc_Connection jdbc_con = new Jdbc_Connection();
			con=jdbc_con.getConnection();
			PreparedStatement prepareStatement = con.prepareStatement("delete from cart where productname ='"+product_delete+"'");
			
			int  j =prepareStatement.executeUpdate();
			System.out.println("done"+j);
			//con.close();
			prepareStatement.close();
				}
			    } catch (Exception e) {
			  e.printStackTrace();
			    }
		
		}
		
	}


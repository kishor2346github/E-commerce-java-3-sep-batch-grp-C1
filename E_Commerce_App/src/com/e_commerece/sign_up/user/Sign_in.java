package com.e_commerece.sign_up.user;
import com.e_commerece.sign_up.user.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.e_commerce.connection.*;

public class Sign_in {
	
	Connection con =null;
	
	public boolean match_signIn_data() throws Exception {
		
	
	 Scanner sc  = new Scanner(System.in);
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
			  
			   System.out.println("==============' Welcome to Home page '=============");
			   
			  }
			  return true;
		  } 
		  con.close();
			prepareStatement.close();
			set.close();
			return false;
}
	
}


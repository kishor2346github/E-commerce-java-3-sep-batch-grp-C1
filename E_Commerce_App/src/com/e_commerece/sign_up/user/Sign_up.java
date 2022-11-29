package com.e_commerece.sign_up.user;
import com.e_commerce.connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sign_up {
    static Connection con =null;
    PreparedStatement prepareStatement =null;
	public void sign_upDetails() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gmail/username : ");
		String gmail =sc.next();
		System.out.println("Enter password : ");
		String pass =sc.next();
		//createtable();
		insertetable(gmail,pass);
		insert_intoe_history_table(gmail);
		System.out.println("**************##########*************");
		sc.close();
	}
	
	/*public void createtable() {
		Jdbc_Connection jdbc_con = new Jdbc_Connection();
		con=jdbc_con.getConnection();
		
		try {
			Statement Statement = con.createStatement();
			Statement.executeUpdate("Create table e_commerce_tabl( gmail varchar(100) primary key not null,pass varchar (150)");
			con.close();
			Statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public  static void insertetable(String gmail,String pass) throws SQLException  {
		Jdbc_Connection jdbc_con = new Jdbc_Connection();
		con=jdbc_con.getConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement("insert into e_commerce_tab(gmail,pass)"+"values(?,?)");
			prepareStatement.setString(1, gmail);
			prepareStatement.setString(2, pass);
			int  i =prepareStatement.executeUpdate();
			System.out.println("done"+i);
			con.close();
			prepareStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("Regestered Succefully");
			
		
		
	}
	
	public  static void insert_intoe_history_table(String gmail) throws SQLException  {
		Jdbc_Connection jdbc_con = new Jdbc_Connection();
		con=jdbc_con.getConnection();
		try {
			PreparedStatement prepareStatement = con.prepareStatement("insert into cart (username)"+"values(?)");
			prepareStatement.setString(1, gmail);
			
			int  i =prepareStatement.executeUpdate();
			System.out.println("done"+i);
			con.close();
			prepareStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("Regestered in history Succefully");
			
		
		
	}
}

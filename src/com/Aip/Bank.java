package com.Aip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;

public class Bank
{

	public static void main(String[] args) 
	{
		try 
		{
			BankInfo bank=new BankInfo();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the choice for bank work");
			System.out.println("1. Insert the data");
			System.out.println("2. Update the data");
			System.out.println("3. Delete the data");
			System.out.println("4. Show the data");
			System.out.println("5. exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				bank.insertInfo();
				break;
			case 2:
				bank.updateInfo();
				break;
			case 3:
				bank.deleteInfo();
				break;
			case 4:
				bank.showInfo();
				break;
			case 5:
				System.out.println("Sorry fill the correct choice");
				break;	
			}
		}
		catch(Exception ex)
		{
			System.err.println("Error Found");
			System.err.println(ex.getMessage());
		}
	}
}



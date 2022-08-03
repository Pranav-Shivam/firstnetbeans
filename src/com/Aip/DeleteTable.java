package com.Aip;
import java.sql.*;
public class DeleteTable {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:Orcale:thin:@localhost::1521:XE";
			String usrnm="system";
			String passwd="root";
			Connection con=DriverManager.getConnection(url, usrnm, passwd);
		}
		catch(Exception ex)
		{
			System.err.println("Error fetched ");
			System.err.println(ex.getMessage());
		}
		

	}

}

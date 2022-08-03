package com.Aip;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class UpdateTable 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loaded ");
			String url="jdbc:Oracle:thin:@localhost:1521:XE";
			String admin="system";
			String passwd="root";
			Connection con=DriverManager.getConnection(url, admin, passwd);
			System.out.println("Connection Build ");
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO student VALUES(5,'Chandan')");
			con.close();
		}
		catch(Exception ex)
		{
			System.err.println("Exception got");
			System.err.println(ex.getMessage());
		}
	}

}

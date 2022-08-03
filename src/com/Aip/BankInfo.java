package com.Aip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class BankInfo 
{
	Connection con;
	Statement st;
	public BankInfo()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loaded");
			 con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
			System.out.println("Connection established");
			st= con.createStatement(); //use connection to fire queries
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("Connection not establish");
		}
	}
	public void insertInfo()
	{
		try
		{
			System.out.println("Inserting records into the table...");
//			String querr="insert into bankdb values(2648,'Chandan',95,88,91,0,'chandan','root')";
//			st.executeUpdate(querr);
//			querr="insert into bankdb values(2619,'Subhi',100,98,100,0,'surbhi','root')";
//			st.executeUpdate(querr);
//			querr="insert into bankdb values(2620,'Sweety',90,95,75,0,'sweety','root')";
//			st.executeUpdate(querr);
//			querr="insert into bankdb values(2619,'Shivam',100,100,100,0,'shiv','root')";
//			st.executeUpdate(querr);
			String querr="insert into bankdb values(2626,'Harsh',100,100,100,0,'harsh','root')";
			st.executeUpdate(querr);
			System.out.println("Data is sucessfully entered");
			con.close();
		}
		catch(Exception ex)
		{
			System.err.println("Error  found");
			System.err.println(ex.getMessage());
		}
	}
	public void updateInfo()
	{
		try
		{
			System.out.println("Updating records into the table...");
			String querr="update bankdb set total=274 where usrnm='chandan'";
			st.executeUpdate(querr);
			querr="update bankdb set total=298 where usrnm='surbhi'";
			st.executeUpdate(querr);
			querr="update bankdb set rollno=2630 where usrnm='surbhi'";
			st.executeUpdate(querr);
			System.out.println("Data is sucessfully updated");
			con.close();
		}
		catch(Exception ex)
		{
			System.err.println("Error  found");
			System.err.println(ex.getMessage());
		}
	}
	public void deleteInfo()
	{
		try
		{
			System.out.println("Deleting records into the table...");
			String querr="delete from bankdb where rollno=2626 ";
			st.executeUpdate(querr);
			System.out.println("Data is sucessfully deleted");
			con.close();
		}
		catch(Exception ex)
		{
			System.err.println("Error  found");
			System.err.println(ex.getMessage());
		}
	}
	public void showInfo()
	{
		try
		{
			System.out.println("Showing records into the table...");
			String querr="select * from bankdb";
			ResultSet rs = st.executeQuery(querr);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getString(8));
			}
			
			con.close();
		}
		catch(Exception ex)
		{
			System.err.println("Error  found");
			System.err.println(ex.getMessage());
		}
	}
}

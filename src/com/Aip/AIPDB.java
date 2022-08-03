package com.Aip;
import java.sql.*;
public class AIPDB {

	public static void main(String[] args){
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
			System.out.println("Connection established");
			Statement st = con.createStatement(); //use connection to fire queries
			ResultSet rs = st.executeQuery("select * from student");  //process result
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			con.close();
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

}


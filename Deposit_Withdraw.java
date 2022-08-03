package Deposit;

import java.sql.*;
import java.util.*;

public class Deposit_Withdraw {

	public void insertInfo() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDb", "root", "root");
			// Statement st=con.createStatement();
			Statement st = con.createStatement();
			// accno integer not null, accname varchar(20) not null,amount int,address
			// varchar(30),mobno int,primary key(accno)
			Scanner sc = new Scanner(System.in);
			System.out.println("Inserting data to bank database ");
			String querry = "insert into banking values(?,?,?,?,?)";
			PreparedStatement pt = con.prepareStatement(querry);
			System.out.println("Enter the accout no.");
			int acc = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the accout holder name ");
			String name = sc.nextLine();
			System.out.println("Eneter the amount you want to add");
			int accBal = sc.nextInt();
			sc.nextLine();
			System.out.println("Eneter the address ");
			String add = sc.nextLine();
			System.out.println("Eneter the mobile no.");
			int mob = sc.nextInt();
			pt.setInt(1, acc);
			pt.setString(2, name);
			pt.setInt(3, accBal);
			pt.setString(4, add);
			pt.setInt(5, mob);
			int i = pt.executeUpdate();
			System.out.println(i + " records inserted");
			con.close();
			System.out.println("Items is inserted ");
		} catch (Exception e) {
			System.err.println("error found");
			System.out.println(e.getMessage());
		}
	}

	public void deposit() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Account no. ");
			int acc = sc.nextInt();
			System.out.println("Enter the amount you want to deposit ");
			int amount = sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDb", "root", "root");
			Statement st = con.createStatement();
			PreparedStatement pt = con.prepareStatement("select * from banking");
			ResultSet rs = pt.executeQuery();
			int q = 0;
			int p = 0;
			boolean flag = false;
			while (rs.next()) {
				p = rs.getInt(1);
				q = rs.getInt(3);
				if (p == acc) {
					q = q + amount;
					System.out.println("The amount  in the account :" + q);
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Account not found");
				return;
			}
			String sql = "update banking set amount=(?) where accno=(?)";
			PreparedStatement ptt = con.prepareStatement(sql);
			ptt.setInt(1, q);
			ptt.setInt(2, p);
			int i = ptt.executeUpdate();
			System.out.println(i + " records updated");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public void withdraw() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Account no. ");
			int acc = sc.nextInt();
			System.out.println("Enter the amount you want to withdraw ");
			int amount = sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDb", "root", "root");
			Statement st = con.createStatement();
			PreparedStatement pt = con.prepareStatement("select * from banking");
			ResultSet rs = pt.executeQuery();
			int q = 0;
			int p = 0;
			boolean flag = false;
			while (rs.next()) {
				p = rs.getInt(1);
				q = rs.getInt(3);
				if (p == acc) {
					q = q - amount;
					System.out.println("The amount left in the account :" + q);
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Account not found");
				return;
			}
			String sql = "update banking set amount=(?) where accno=(?)";
			PreparedStatement ptt = con.prepareStatement(sql);
			ptt.setInt(1, q);
			ptt.setInt(2, p);
			int i = ptt.executeUpdate();
			System.out.println(i + " records updated");
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}

	}

	public void searchInfo() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Account no. which you want to search ");
			int acc = sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDb", "root", "root");
			Statement st = con.createStatement();
			PreparedStatement pt = con.prepareStatement("select * from banking");
			ResultSet rs = pt.executeQuery();
			int p = 0;
			boolean flag = false;
			while (rs.next()) {
				p = rs.getInt(1);
				if (p == acc) {
					System.out.println("Account no is " + p);
					System.out.println("Account holder name is " + rs.getString(2));
					System.out.println("Account balance is " + rs.getInt(3));
					System.out.println("Account holder address is " + rs.getString(4));
					System.out.println("Account holder mobile no. is " + rs.getInt(5));
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Account not found");
				return;
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public void transfer() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Account no. from where you want to transfer");
			int acc1 = sc.nextInt();
			System.out.println("Enter the Account no. from in which you want to transfer");
			int acc2 = sc.nextInt();
			System.out.println("Enter the amount you want to tranfer ");
			int amount = sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newDb", "root", "root");
			Statement st = con.createStatement();
			PreparedStatement pt = con.prepareStatement("select * from banking");
			ResultSet rs = pt.executeQuery();
			int q = 0;
			int p = 0;
			boolean flag = false;
			while (rs.next()) {
				p = rs.getInt(1);
				q = rs.getInt(3);
				if (p == acc1) {
					q = q - amount;
					System.out.println("The amount left in the account :" + q);
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println("Account not found");
				return;
			}
			String sql = "update banking set amount=(?) where accno=(?)";
			PreparedStatement ptt = con.prepareStatement(sql);
			ptt.setInt(1, q);
			ptt.setInt(2, p);
			int i = ptt.executeUpdate();
			System.out.println(i + " records updated");
			//transfer
			PreparedStatement pt2 = con.prepareStatement("select * from banking");
			ResultSet rs1 = pt2.executeQuery();
			int q1 = 0;
			int p1 = 0;
			boolean flag1 = false;
			while (rs1.next()) {
				p1 = rs1.getInt(1);
				q1 = rs1.getInt(3);
				if (p1 == acc2) {
					q1 = q1 + amount;
					System.out.println("The amount  in the account :" + q1);
					flag1 = true;
					break;
				}
			}
			if (!flag1) {
				System.out.println("Account not found");
				return;
			}
			String sql1 = "update banking set amount=(?) where accno=(?)";
			PreparedStatement pt1 = con.prepareStatement(sql1);
			ptt.setInt(1, q1);
			ptt.setInt(2, p1);
			int i1 = ptt.executeUpdate();
			System.out.println(i1 + " records updated");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
}

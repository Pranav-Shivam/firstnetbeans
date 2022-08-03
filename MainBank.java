package Deposit;

import java.util.Scanner;

public class MainBank {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Deposit_Withdraw dw=new Deposit_Withdraw();
			while(true) 
			{
				System.out.println("\n");
				System.out.println("Enter the Choice ");
				System.out.println("Press 1 for Inserting data");
				System.out.println("Press 2 for Deposit ");
				System.out.println("Press 3 for Withdraw");
				System.out.println("Press 4 for seacrch info");
				System.out.println("Press 5 for transfer money");
				System.out.println("Press 6 for exit ");

				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					dw.insertInfo();
					break;
				case 2:
					dw.deposit();
					break;
				case 3:
					dw.withdraw();
					break;
				case 4:
					dw.searchInfo();
					break;
				case 5:
					dw.transfer();
					break;
				case 6:
					System.out.println("exit...");
					  
	                // Terminate JVM
	                System.exit(0);
					break;
				}
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}

}

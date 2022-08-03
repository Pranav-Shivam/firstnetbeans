package com.Aip;
import java.util.*;
public class SumAndAvg {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array ");
		int n=sc.nextInt();
		int sum=0;
		double avg;
		int arr[]=new int[n];
		System.out.println("Enter the array elements ");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		double s=sum;
		double a=n;
		avg=s/a;
		System.out.println("Sum ="+sum);
		System.out.println("Average ="+avg);
	}

}

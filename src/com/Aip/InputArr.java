package com.Aip;

import java.util.Scanner;

public class InputArr {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("The size of array is 10 ");
		int n=10;
		int arr[]=new int[n];
		System.out.println("Enter the array elements ");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		System.out.println("The array elements ");
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]+"\t");
		}
	}

}

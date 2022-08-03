package com.Aip;

import java.util.*;
public class SumAndAverage {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array elements ");
		int size=sc.nextInt();
		int sum=0;
		double avg;
		int arr[]=new int[size];
		System.out.println("Enter the array elements ");
		for(int i=0;i<size;i++)
		{
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		double sumA=sum;
		double n=size;
		avg=sumA/n;
		System.out.println("Sum ="+sumA);
		System.out.println("Average ="+avg);
	}

}

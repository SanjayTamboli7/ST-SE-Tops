package com.exception;

import java.util.Scanner;

public class DemoException {
	

public static void main(String[] args) 
{
	try { 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No 1: ");
		int a=sc.nextInt();
		
//		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No 2: ");
		int b=sc.nextInt();
		
		int c=a/b;
		System.out.println("Divsion is "+c);
		System.out.println("Your program is completed...");
		
	
	   }
		catch (Exception e)
	{
			e.printStackTrace();
	}
	finally
	{
		System.out.println("This is finally section");
	}
	

}
}
package com.oops;

import java.util.Scanner;

/* Write a program to print the factorial of a number by defining a method named 
'Factorial'. Factorial of any number n is represented by n! And is equal to 1*2*3*.
  
*(n-1) *n. E.g.- 
4! = 1*2*3*4 = 24 
3! = 3*2*1 = 6 
2! = 2*1 = 2 
Also, 1! = */

public class ModlCoreJavaCode31 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  
		int num = -1;
		int factorial=1;
		while (num <= 0) {
			System.out.println("Find the factorial for = ");  
			num = sc.nextInt();
		}		
		for(int i=1;i<=num;i++)
		{
			if (i>1) {
				System.out.print(i);
				factorial = factorial * i;
				System.out.print(" X ");
			}
		}
		System.out.println("1 = " + factorial);
	}
}

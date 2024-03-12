package com.oops;

/*

Write a program in Java to display the first 10 natural numbers using while loop.    
 
*/

public class ModlCoreJavaCode04 {
	public static void main(String[] args) {
		System.out.print("First 10 Natural Numbers are : ");
		int ctr = 1;
		while (ctr <= 10) {
			if (ctr > 1) 
			{
				System.out.print(", ");				
			}
			System.out.print(ctr);
			ctr++;
		}
	}
}

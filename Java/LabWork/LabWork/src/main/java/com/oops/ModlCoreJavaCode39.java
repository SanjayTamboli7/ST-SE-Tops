package com.oops;

import java.util.Scanner;

/* W.A.J.P to create the validate method that takes integer value as a parameter. If the 
age is less than 18, then throw an Arithmetic Exception otherwise print a message 
welcome to vote.  
O/P- Enter your age: 16 
Exception in thread main java. Lang. Arithmetic Exception: not valid  */

public class ModlCoreJavaCode39 {

	public static void validate(int age) {
		if (age < 18) {
			throw new ArithmeticException("Person is not eligible to vote");
		} else {
			System.out.println("Person is eligible to vote!!");
		}
	}

	public static void main(String[] args) {

		int Age = -1;
		Scanner sc = new Scanner(System.in);
		while (Age <= 0) {
			System.out.println("Enter the age : ");
			Age = sc.nextInt();
		}
		validate(Age);
	}
}

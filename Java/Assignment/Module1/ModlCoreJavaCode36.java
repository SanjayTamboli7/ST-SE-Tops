package com.oops;

/* Take two numbers from the user and perform the division operation and handle Arithmetic Exception. 
 * O/P- Enter two numbers: 10 0  
   Exception in thread main java.lang.ArithmeticException:/ by zero */

import java.util.Scanner;

public class ModlCoreJavaCode36 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			Double a = (double) -1;
			Double b = (double) -1;

			while (a < 0) {
				System.out.print("Enter first number : ");
				a = sc.nextDouble();
			}
			while (b < 0) {
				System.out.print("Enter second number : ");
				b = sc.nextDouble();
			}
			try {
				Double Result = a / b;
				System.out.println("Division result = " + Result);
			}

			catch (ArithmeticException e) {
				System.out.println("ArithmeticException => " + e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

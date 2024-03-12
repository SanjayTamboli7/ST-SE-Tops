package com.oops;

import java.util.Scanner;

/*

Write a Java program that takes a year from user and print whether that year is a leap  year or not. B19. 
Write a program in Java to display the first 10 natural numbers using while loop.    
 
*/
public class ModlCoreJavaCode03 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int intYear = 0;
			String result;

			while (intYear <= 999) {
				System.out.println("Enter Year : ");
				intYear = sc.nextInt();
				if (intYear <= 999) {
					System.out.println("You should enter year in 4 digit...");
				} else {
					result = (intYear % 4 == 0 && intYear % 100 != 0 || intYear % 400 == 0) ? "is a leap year"
							: "is not a leap year";
					System.out.println(intYear + " " + result + ".");
				}
			}
		}
	}
}

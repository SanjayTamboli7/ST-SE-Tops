package com.oops;

import java.util.Scanner;

/* Write a Java program to print the ASCII value of a given character. */

public class ModlCoreJavaCode09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a character: ");
		char input = scanner.next().charAt(0);
		System.out.println("You entered: " + input);
		int ascii = input;
		System.out.println("The ASCII value of " + input + " is: " + ascii);
		scanner.close();
	}
}

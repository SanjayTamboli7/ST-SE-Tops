package com.oops;

import java.util.Scanner;

/*
 * Example 2
 * 
 * Write a Java program that takes the user to provide a single character from
 * the alphabet. Print Vowel or Consonant, depending on the user input. If the
 * user input is not a letter (between a and z or A and Z), or is a string of
 * length > 1, print an error message.
 * 
 */

public class ModlCoreJavaCode02 {
	public static void main(String[] args) {
		System.out.println("Example 2 Find vowel or constant");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter String : ");
			String userInput = sc.nextLine();
			System.out.println("User Input : " + userInput);
			if (userInput.length() == 1) {
				char userch = userInput.charAt(0);
				if (userch == 'A' || userch == 'E' || userch == 'I' || userch == 'O' || userch == 'U' || userch == 'a'
						|| userch == 'e' || userch == 'i' || userch == 'o' || userch == 'u') {
					System.out.println(userInput + " is vowel");
				} else {
					System.out.println(userInput + " is constant");
				}
			} else {
				System.out.println("Enter only one character...");
			}
		}
	}
}

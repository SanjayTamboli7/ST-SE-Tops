package com.oops;

/*
Example 3 

Write a Java program that takes a year from user and print whether that year is a leap year or not. B19. Write a program 
in Java to display the first 10 natural numbers using while loop.


• Write a program in Java to input 5 numbers from keyboard and find their sum and 
average using for loop.  
• Write a program in Java to display the pattern like right angle triangle with a number. 
 
 */
import java.util.Scanner;

public class ModlCoreJavaCode02 {
	public static void main(String[] args) {
		System.out.println("Example 2 Find vowel or constant");
		try (Scanner sc = new SBcanner(System.in)) {
			System.out.println("Enter String : ");
			String userInput = sc.nextLine();
			System.out.println("User Input : " + userInput);
			if (userInput.length() == 1) {
				if (userInput == "A" || userInput == "E" || userInput == "I" || userInput == "O" || userInput == "U"
						|| userInput == "a" || userInput == "e" || userInput == "i" || userInput == "o"
						|| userInput == "u") {
					System.out.println(userInput + " is vowel");
				} else {
					System.out.println(userInput + " is constant");
				}
			}
			{
				System.out.println("Enter only one character...");
			}
		}
	}
}

package com.oops;

import java.util.Scanner;

public class Temporary {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
		System.out.println("You are " + age + " years old.");

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.println("Hello, " + name + "!");

		scanner.close();
	}
}

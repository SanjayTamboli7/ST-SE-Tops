package com.oops;

/* Write a Java program to replace the second element of an Array List with the specified element. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ModlCoreJavaCode71 {
	public static void main(String[] args) {

		// create ArrayList
		ArrayList<String> colours = new ArrayList<String>();

		// Add elements to ArrayList
		colours.add("Green");
		colours.add("Blue");
		colours.add("Red");
		colours.add("Brown");
		colours.add("Purple");
		colours.add("Black");
		colours.add("Yellow");
		colours.add("Grey");
		colours.add("White");

		System.out.println("Array size : " + colours.size());
		System.out.println("Original ArrayList: " + colours);

		try (Scanner scn = new Scanner(System.in)) {
			System.out.println("Enter the element position to swap : ");
			int position = scn.nextInt();
			if (position < 0 || position > colours.size() - 1) {
				System.out.println("Invalid position!");
			} else {
				Collections.swap(colours, 1, position);
				System.out.println("Swapped ArrayList: " + colours);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

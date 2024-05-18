package com.oops;

import java.util.ArrayList;

/* Write a Java program to extract a portion of an array list. */

public class ModlCoreJavaCode63 {
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

		System.out.println("Original ArrayList: " + colours);
		System.out.println("First 3 elemements of ArrayList: " + colours.subList(0, 3));
	}
}

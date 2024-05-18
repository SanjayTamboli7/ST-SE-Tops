package com.oops;

import java.util.ArrayList;
import java.util.Collections;

/* Write a Java program to reverse elements in an array list. */

public class ModlCoreJavaCode62 {
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
		Collections.reverse(colours);
		System.out.println("Reversed ArrayList: " + colours);
	}
}

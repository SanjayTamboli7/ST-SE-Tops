package com.oops;

/* Write a Java program to increase the size of an array list. */

import java.util.ArrayList;

public class ModlCoreJavaCode70 {
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
		System.out.println("Original array size = " + colours.size());
		colours.ensureCapacity(colours.size()*2);
		System.out.println("Revised array size = " + colours.size());

	}
}

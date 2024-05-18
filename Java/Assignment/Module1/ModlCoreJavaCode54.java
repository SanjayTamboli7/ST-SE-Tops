package com.oops;

/* Write a Java program to sort a given array list.  Page 48*/

import java.util.ArrayList;
import java.util.Collections;

public class ModlCoreJavaCode54 {
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
		Collections.sort(colours);
		System.out.println("Sorted ArrayList: " + colours);		
	}
}

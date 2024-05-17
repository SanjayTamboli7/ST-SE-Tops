package com.oops;

import java.util.ArrayList;
import java.util.Collections;

/* Write a Java program to join two array lists. */

public class ModlCoreJavaCode66 {
	public static void main(String[] args) {

		// create ArrayList
		ArrayList<String> colours = new ArrayList<String>();
		ArrayList<String> colours1 = new ArrayList<String>();

		// Add elements to ArrayList
		colours.add("Green");
		colours.add("Blue");
		colours.add("Red");
		colours.add("Brown");
		colours.add("Purple");
		
		colours1.add("Black");
		colours1.add("Yellow");
		colours1.add("Grey");
		colours1.add("White");

		System.out.println("Original ArrayList: " + colours);
		System.out.println("Original ArrayList: " + colours1);
		
		colours.addAll(colours1);
		System.out.println("Swapped ArrayList: " + colours);
	}
}

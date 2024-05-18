package com.oops;

import java.util.ArrayList;

/* Write a Java program to compare two array lists. */

public class ModlCoreJavaCode64 {
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

		System.out.println("ArrayList 1: " + colours);

		DeepCopyExample objCopyExample = new DeepCopyExample();
		ArrayList<String> colours3 = objCopyExample.deepCopy(colours);
		System.out.println("Deep copy ArrayList: " + colours3);
		
		System.out.println("Equality test 1 result = " + colours.equals(colours3));
		
		colours3.add("Cyan") ;
		System.out.println("ArrayList 1: " + colours3);
		System.out.println("Equality test 2 result = " + colours.equals(colours3));

	}
}

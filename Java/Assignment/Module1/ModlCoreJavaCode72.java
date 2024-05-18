package com.oops;

/* Write a Java program to print all the elements of an Array List using the position of the elements. */

import java.util.ArrayList;
import java.util.*;

public class ModlCoreJavaCode72 {
	public static void main(String[] args) {

		// create ArrayList
		ArrayList<String> colours = new ArrayList<String>();
		int ctr = 0;

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

		ListIterator<String> iterator = colours.listIterator();

		// Printing the iterated value
		System.out.println("\nUsing ListIterator:\n");
		System.out.println("Position Value");

		while (iterator.hasNext()) {
//			System.out.println("Value is : " + iterator.next());
			System.out.println(ctr + "        " + iterator.next());
			ctr++;
		}
	}
}

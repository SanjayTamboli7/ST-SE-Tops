package com.oops;

import java.util.ArrayList;
import java.util.Scanner;

/* Write a Java program to retrieve an element (at a specified index) from a given array list.  */

public class ModlCoreJavaCode50 {
	public static void main(String[] args) {

		// create ArrayList
		ArrayList<String> colours = new ArrayList<>();		

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

	    System.out.println("ArrayList: " + colours);
		
		try (Scanner scn = new Scanner(System.in)) {

			int arrPosition = 0;
			int upperLimit =  colours.size();

			while (arrPosition >= 0 && arrPosition <= upperLimit) {
				try {
					System.out.println("Enter any number (0-" + upperLimit + "): ");
					arrPosition = scn.nextInt();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (arrPosition >= 0 && arrPosition <= upperLimit ) {
					System.out.println("Element at position " + " is " + colours.get(arrPosition));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

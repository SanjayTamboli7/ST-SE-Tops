package com.oops;

import java.util.ArrayList;
import java.util.Scanner;

/* Write a Java program to search an element in an array list. */

public class ModlCoreJavaCode53 {
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

			String strColour = "" ;
						
			while (true) {
				try {
					System.out.println("Enter color : ");
					strColour = scn.nextLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (strColour.length() > 0) {
					System.out.println("Element at position " + " is " + colours.indexOf(strColour));
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.oops;

import java.util.ArrayList;
import java.util.ListIterator;

/* Write a Java program to iterate through all elements in an array list. */

public class ModlCoreJavaCode48 {
	public static void main(String[] args) {

	    // create ArrayList
	    ArrayList<String> colours = new ArrayList<>();
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
	    
	    System.out.println("Way 1 to see all values of array list");
	    System.out.println("ArrayList: " + colours);
	    
	    System.out.println("Way 2 to iterate thru array list");
	    ListIterator<String> iterator = colours.listIterator();
	    
        while (iterator.hasNext()) {
        	ctr++;
            System.out.println("Value " + ctr + ": " + iterator.next());
        }
	}
}

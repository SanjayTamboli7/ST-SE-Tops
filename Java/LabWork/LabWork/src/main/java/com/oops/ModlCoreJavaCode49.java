package com.oops;

import java.util.ArrayList;
import java.util.ListIterator;

/* Write a Java program to insert an element into the array list at the first position. */

public class ModlCoreJavaCode49 {
	public static void main(String[] args) {
		
	    // create ArrayList
	    ArrayList<String> colours = new ArrayList<>();
	    int ctr = 0;

	    // Add elements to ArrayList
	    
//	    colours.add("Green");
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
	    
	    System.out.println();
	    
	    System.out.println("Way 2 to iterate thru array list");
	    ListIterator<String> iterator = colours.listIterator();
	    
        while (iterator.hasNext()) {
        	ctr++;
            System.out.println("Value " + ctr + ": " + iterator.next());
        }
        
        colours.add(0, "Green");

	    System.out.println();

	    System.out.println("Way 1 to see all values of array list");
	    System.out.println("ArrayList: " + colours);
	    
	    System.out.println();

	    System.out.println("Way 2 to iterate thru array list");
	    ctr = 0;
	    ListIterator<String> iterator1 = colours.listIterator();
	    
        while (iterator1.hasNext()) {
        	ctr++;
            System.out.println("Value " + ctr + ": " + iterator1.next());
        }
	}
}

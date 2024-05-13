package com.oops;

/* Write a Java program to copy one array list into another. */

import java.util.ArrayList;

class DeepCopyExample {
	 
    // Method to create a deep copy of an ArrayList 
	ArrayList<String> 
    deepCopy(ArrayList<String> originalList) 
    { 
        // Create a new ArrayList to store the copied 
        // elements 
        ArrayList<String> copiedList = new ArrayList<>(); 
  
        // Iterate over each element in the original list 
        for (String item : originalList) { 
            // Creating a new instance of each element 
            copiedList.add(new String(item)); 
        } 
  
        // Return the deep copied list 
        return copiedList; 
    } 
}

public class ModlCoreJavaCode55 {
	
	@SuppressWarnings("unchecked")
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
		ArrayList<String> colours2 = (ArrayList<String>)colours.clone();
		System.out.println("Shallow / clone ArrayList: " + colours2);
		
		DeepCopyExample objCopyExample = new DeepCopyExample();
		ArrayList<String> colours3 = objCopyExample.deepCopy(colours);
		System.out.println("Deep copy ArrayList: " + colours3);		
		
	}
}

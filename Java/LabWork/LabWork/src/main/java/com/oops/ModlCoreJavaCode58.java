package com.oops;

/* Write a Java program to iterate through all elements in a hash list. */

import java.util.*;

public class ModlCoreJavaCode58 {
	public static void main(String[] args) {
		
		// Creating Hashtable object where key is of Integer
		// type
		// and value is of String type
		Hashtable<Integer, String> ht = new Hashtable<>();

		// Putting key-value pairs to HashTable object
		// Custom input entries
		ht.put(1, "Java");
		ht.put(2, "Scala");
		ht.put(3, "Python");
		ht.put(4, "Pearl");
		ht.put(5, "R");

		// Getting keySets of Hashtable and
		// storing it into Set
		Set<Integer> setOfKeys = ht.keySet();

		// Creating an Iterator object to
		// iterate over the given Hashtable
		Iterator<Integer> itr = setOfKeys.iterator();

		// Iterating through the Hashtable object
		// Checking for next element using hasNext() method
		while (itr.hasNext()) {

			// Getting key of a particular entry
			int key = itr.next();

			// Print and display the Rank and Name
			System.out.println("Rank : " + key + "\t Course : " + ht.get(key));
		}		
	}
}
package com.oops;

import java.util.Arrays;

/* Write a Java program to get the number of elements in a hash set. */

import java.util.HashSet;

public class ModlCoreJavaCode59 {
	public static void main(String[] args) {

		// Initialize HashSet using Constructor
		HashSet<String> myhashset = new HashSet<>(
				Arrays.asList("Green", "Blue", "Red", "Brown", "Purple", "Black", "Yellow", "Grey", "White"));

		// printing hashset values
		System.out.println("HashSet Initialized Using Constructor: " + myhashset);
		System.out.println( "Number of elements : " + myhashset.size() );

	}
}

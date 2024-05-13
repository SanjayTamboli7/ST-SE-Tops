package com.oops;

/* Write a Java program to append the specified element to the end of a hash set. */

import java.util.HashSet;
import java.util.Arrays;

public class ModlCoreJavaCode57 {
	public static void main(String[] args) {

		// Initialize HashSet using Constructor
		HashSet<String> myhashset = new HashSet<>(
				Arrays.asList("Green", "Blue", "Red", "Brown", "Purple", "Black", "Yellow", "Grey", "White"));

		// printing hashset values
		System.out.println("HashSet Initialized Using Constructor: " + myhashset);
		myhashset.add("Cyan");
		System.out.println("HashSet Initialized Using Constructor: " + myhashset);
	}
}

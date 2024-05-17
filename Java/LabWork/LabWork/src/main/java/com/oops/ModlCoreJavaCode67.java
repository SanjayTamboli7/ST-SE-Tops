package com.oops;

/* Write a Java program to convert a hash set to an array. */

import java.util.*;

public class ModlCoreJavaCode67 {
	public static void main(String[] args) {

		// Creating a hash set of strings
		Set<String> s = new HashSet<String>();
		s.add("Geeks");
		s.add("for");

		int n = s.size();
		String arr[] = new String[n];

		int i = 0;
		for (String x : s)
			arr[i++] = x;

		System.out.println(Arrays.toString(arr));
	}
}

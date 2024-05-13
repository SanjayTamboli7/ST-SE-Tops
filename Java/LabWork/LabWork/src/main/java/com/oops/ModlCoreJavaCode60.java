package com.oops;

/* Write a Java program to associate the specified value with the specified key in a Hash Map. */

import java.util.*;

public class ModlCoreJavaCode60 {
	public static void main(String[] args) {
		HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
		hash_map.put(1, "Red");
		hash_map.put(2, "Green");
		hash_map.put(3, "Black");
		hash_map.put(4, "White");
		hash_map.put(5, "Blue");
		for (@SuppressWarnings("rawtypes")
		Map.Entry x : hash_map.entrySet()) {
			System.out.println(x.getKey() + " " + x.getValue());
		}
	}
}
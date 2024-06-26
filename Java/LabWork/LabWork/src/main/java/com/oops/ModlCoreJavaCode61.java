package com.oops;

import java.util.HashMap;
import java.util.Map;

/* Write a Java program to count the number of key-value (size) mappings in a map. */

public class ModlCoreJavaCode61 {
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
		
		System.out.println("Size of Hash_map : "+hash_map.size());
	}
}

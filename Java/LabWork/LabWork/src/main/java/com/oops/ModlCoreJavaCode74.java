package com.oops;

/* Write a Java program to get a collection view of the values contained in this map. */

import java.util.HashMap;

public class ModlCoreJavaCode74 {
	public static void main(String[] args) {
		// Create a new HashMap
		HashMap<String, Integer> studentGrades = new HashMap<>();
		// Add key-value pairs to the HashMap
		studentGrades.put("Alice", 95);
		studentGrades.put("Bob", 80);
		studentGrades.put("Charlie", 75);
		// Print the HashMap
		System.out.println("HashMap: " + studentGrades);
		// Get the value for a specific key
		int bobGrade = studentGrades.get("Bob");
		System.out.println("Bob's Grade: " + bobGrade);
		// Check if a key exists
		boolean hasCharlie = studentGrades.containsKey("Charlie");
		System.out.println("Does Charlie exist? " + hasCharlie);
		// Remove a key-value pair
		studentGrades.remove("Alice");
		// Check the size of the HashMap
		int size = studentGrades.size();
		System.out.println("Size of the HashMap: " + size);
		// Iterate over the HashMap
		System.out.println("Iterating over the HashMap:");
		for (String name : studentGrades.keySet()) {
			int grade = studentGrades.get(name);
			System.out.println(name + "'s Grade: " + grade);
		}
		// Update a value
		studentGrades.put("Bob", 90);
		int updatedBobGrade = studentGrades.get("Bob");
		System.out.println("Updated Bob's Grade: " + updatedBobGrade);
		// Clear the HashMap
		studentGrades.clear();
		// Check if the HashMap is empty
		boolean isEmpty = studentGrades.isEmpty();
		System.out.println("Is the HashMap empty? " + isEmpty);

	}
}

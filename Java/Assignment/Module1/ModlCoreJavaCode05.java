package com.oops;

import java.util.Scanner;

/* Write a program in Java to input 5 numbers from keyboard and find their sum and average using for loop. */

public class ModlCoreJavaCode05 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			System.out.println("How many elements :");
			int arrayElements = scn.nextInt();
			int[] intArray = new int[arrayElements];
			int sum = 0;
			for (int ctr = 0; ctr <= arrayElements - 1; ctr++) {
				System.out.println("Enter " + (ctr+1) + " Element of Array");
				intArray[ctr] = scn.nextInt();
				sum = sum + intArray[ctr];
			}
			System.out.println("   Sum = " + sum);
			System.out.println("Averge = " + sum / (intArray.length));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package com.oops;

import java.util.Scanner;

/*
 * 
Write a Java program that reads a positive integer and count the number of digits the 
number.  
Input an integer number less than ten billion: 125463 
Number of digits in the number: 6

*/
public class ModlCoreJavaCode07 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			System.out.println("Input an integer number less than ten billion :");
			int inputNo = scn.nextInt();
			String noToString = String.valueOf(inputNo);
			System.out.println("Number of digits in the number: " + noToString.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

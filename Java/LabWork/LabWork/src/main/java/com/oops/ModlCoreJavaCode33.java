package com.oops;

import java.util.Scanner;

/*  Write a program which will ask the user to enter his/her marks (out of 100). 
Define a method that will display grades according to the marks entered as below:  

Marks Grade 

1-100 A 
1-90  B 
1-80  B 
1-70  C 
1-60  D 
41-50 DD 
40    Fail */

public class ModlCoreJavaCode33 {
	public static void main(String[] args) {

		int marks = -1;
		String Grade = "";

		try (Scanner sc = new Scanner(System.in)) {
			while (marks <= 0) {
				System.out.println("Enter Marks : ");
				marks = sc.nextInt();
			}
			if (marks > 90 && marks <= 100) {
				Grade = "A";
			}
			if (marks > 70 && marks <= 90) {
				Grade = "B";
			}
			if (marks > 60 && marks <= 70) {
				Grade = "C";
			}
			if (marks > 50 && marks <= 60) {
				Grade = "D";
			}
			if (marks > 40 && marks <= 50) {
				Grade = "DD";
			}
			if (marks <= 40) {
				Grade = "Fail";
			}
			System.out.println("Grade = " + Grade);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

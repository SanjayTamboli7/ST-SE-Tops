package com.oops;

import java.util.Scanner;
import java.io.*;

/* Write a Java program to count the letters, spaces, numbers and other characters of  an input string.  */

public class ModlCoreJavaCode08 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			System.out.print("Enter a string: ");
			String str = sc.nextLine(); // reads string
			int totalNos, totalChars, totalSpclChars, totalWhiteSpaces;
			totalNos = totalChars = totalSpclChars = totalWhiteSpaces = 0;
			for (int ctr = 0; ctr <= str.length() - 1; ctr++) {
				if (Character.isDigit(str.charAt(ctr))) {
					totalNos = totalNos + 1;
				} else {
					if (Character.isLetter(str.charAt(ctr))) {
						totalChars = totalChars + 1;
					} else {
						if (Character.isWhitespace(str.charAt(ctr))) {
							totalWhiteSpaces = totalWhiteSpaces + 1;
						} else {
							totalSpclChars = totalSpclChars + 1;
						}
					}
				}
			}
			System.out.println("Total Special Characters : " + totalSpclChars);
			System.out.println("        Total Characters : " + totalChars);
			System.out.println("           Total Numbers : " + totalNos);
			System.out.println("      Total White Spaces : " + totalWhiteSpaces);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

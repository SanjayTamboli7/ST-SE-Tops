package com.oops;

import java.util.Scanner;
import java.io.*;

/* Write a Java program to count the letters, spaces, numbers and other characters of  an input string.  */

public class ModlCoreJavaCode19 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			System.out.print("Enter a string: ");
			String str = sc.nextLine(); // reads string
			String strOfChars = "";
			char strChar1 ;
			for (int ctr = 0; ctr <= str.length() - 1; ctr++) {
				strChar1 = str.charAt(ctr);
				System.out.println(strChar1);
				
				if (strOfChars.contains(strChar1)) {
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

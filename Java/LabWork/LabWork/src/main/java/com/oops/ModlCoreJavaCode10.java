package com.oops;

import java.util.Scanner;

/* Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn. Input number: 5  
5 + 55 + 555 
*/
public class ModlCoreJavaCode10 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			int inputNo = 0;
			int total = 0;
			int inputNewNo = 0;
			String No2Str;
			while (true) {
				System.out.println("Input one digit integer number :");
				inputNo = scn.nextInt();
				if (inputNo > 0 && inputNo < 10) {
					break;
				}
			}
			No2Str = "";
//			System.out.println("a " + No2Str + " User Input : " + inputNo);
			for (int ctr = 1; ctr <= 3; ctr++) {
				No2Str = No2Str + Integer.toString(inputNo);
				System.out.print(No2Str + " + ");
				inputNewNo = Integer.valueOf(No2Str);
				total = total + inputNewNo;
			}
			System.out.print(" = " + total);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

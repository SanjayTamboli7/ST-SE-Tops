package com.oops;

/* Write a Java program to print numbers between 1 to 100 which are divisible by 3, 5 
and by both.  */

public class ModlCoreJavaCode12 {
	public static void main(String[] args) {
		for (int ctr = 1; ctr <= 100; ctr++) {
			if ((ctr % 3 == 0) && (ctr % 5 == 0)) {
				System.out.println(ctr + " is divisible by 3 & 5 both");
			} else {
				if (ctr % 3 == 0) {
					System.out.println(ctr + " is divisible by 3");
				}
				if (ctr % 5 == 0) {
					System.out.println(ctr + " is divisible by 5");
				}
			}
		}
	}
}

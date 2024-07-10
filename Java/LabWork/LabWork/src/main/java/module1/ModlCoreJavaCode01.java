package module1;

import java.util.Scanner;

/* 
Module 2 Core Java 

Example 1

Write a Java program to Take three numbers from the user and print the greatest number. 
 
*/

public class ModlCoreJavaCode01 {
	public static void main(String[] args) {

		System.out.println("Example 1 Greatest of any 3 numbers");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number 1 : ");
		int no1 = sc.nextInt();

		System.out.println("Enter Number 2 : ");
		int no2 = sc.nextInt();

		System.out.println("Enter Number 3 : ");
		int no3 = sc.nextInt();

		int maxno = 0;

		if (no1 > no2) {
			if (no2 > no3) {
				maxno = no1;
			} else {
				maxno = no2;
			}
		} else {
			if (no2 > no3) {
				maxno = no2;
			} else {
				maxno = no3;
			}
		}
		System.out.println("Maximu Number is : " + maxno);
	}
}

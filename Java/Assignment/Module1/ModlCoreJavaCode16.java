package com.oops;

import java.util.Scanner;

/* W.A.J.P to check whether a given string ends with the contents of another string. 
"Java Exercises" ends with "se"? False "Java Exercise" ends with "es"? True  */

public class ModlCoreJavaCode16 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string 1 : ");
		String strName1 = sc.nextLine();
		System.out.println("Enter string 2 : ");
		String strName2 = sc.nextLine();		
		if (strName1.endsWith(strName2)) {
			System.out.println(strName1 + " ends with " + strName2);
		} else {
			System.out.println(strName1 + " does not end with " + strName2);
		}
	}
}

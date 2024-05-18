package com.oops;

/* W.A.J.P to compare a given string to the specified character sequence. 
 * Comparing topsint.com and topsint.com: true Comparing Topsint.com and topsint.com: false*/

import java.util.Scanner;

public class ModlCoreJavaCode15 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter First Name : ");
			String strName1 = sc.nextLine();
			System.out.println("Enter Last Name : ");
			String strName2 = sc.nextLine();
//			boolean result = (strName1 == strName2 ? true : false);
			if (strName1.equals(strName2)) {
				System.out.println(strName1 + " = " + strName2);
			} else {
				System.out.println(strName1 + " != " + strName2);
			}
		}
	}
}

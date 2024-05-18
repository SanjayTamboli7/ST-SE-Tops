package com.oops;

import java.util.Scanner;

public class ModlCoreJavaCode17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string 1 : ");
		String strName1 = sc.nextLine();
		System.out.println("Enter string 2 : ");
		String strName2 = sc.nextLine();		
		if (strName1.startsWith(strName2)) {
			System.out.println(strName1 + " starts with " + strName2);
		} else {
			System.out.println(strName1 + " does not start with " + strName2);
		}
	}
}

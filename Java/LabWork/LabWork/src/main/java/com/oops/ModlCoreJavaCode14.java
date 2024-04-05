package com.oops;

import java.util.Scanner;

/* W.A.J.P to concatenate a given string to the end of another string. */

public class ModlCoreJavaCode14 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter First Name : ");
			String strName1 = sc.nextLine();
			System.out.println("Enter Last Name : ");
			String strName2 = sc.nextLine();
			String strName3 = strName2.concat(" " + strName1) ;
			System.out.println("Full name is " + strName3);
		}		
	}
}

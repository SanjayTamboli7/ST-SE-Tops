package com.oops;

/* Create a class to print an integer and a character with two methods having the same name but different sequence of the integer and 
   the character parameters. For example, if the parameters of the first method are of the form (int n, char c), then that of the 
   second method will be of the form (char c, int n).  */

class PrintCharInt {
	
	void PrintCharInt1(int n, String c) {
		System.out.println("Integer = " + n);
		System.out.println("Character = " + c);
	}

	void PrintCharInt1(String c, int n) {
		System.out.println("Character = " + c);
		System.out.println("Integer = " + n);		
	}
}

public class ModlCoreJavaCode21 {
	public static void main(String[] args) {
		
		PrintCharInt objPrintCharInt = new PrintCharInt() ;
		objPrintCharInt.PrintCharInt1(100, "Hundred");
		System.out.println("--------------------");
		objPrintCharInt.PrintCharInt1("Thousand", 1000);
	}
}

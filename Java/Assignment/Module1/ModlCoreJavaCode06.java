package com.oops;

/* 

Write a program in Java to make such a pattern like right angle triangle with number 
increased by 1 The pattern like:  
 
1 
2 3 
4 5 6 
7 8 9 10 

*/
public class ModlCoreJavaCode06 {
	public static void main(String[] args) {
		int printValue = 0;
		for (int extCtr = 0; extCtr <= 3; extCtr++) {
			for (int intCtr = 0; intCtr <= extCtr; intCtr++) {
				System.out.print(++printValue);
			}
			System.out.println();
		}
	}
}

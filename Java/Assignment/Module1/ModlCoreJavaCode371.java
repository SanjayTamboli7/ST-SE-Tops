package com.oops;

/* W.A.J. P to demonstrate multiple catch blocks, (one is to handle divide by zero 
exception and another one is to handle  
ArrayIndexOutOfBoundException) int a [] =new int [5]; a [5]=30/0;  */

public class ModlCoreJavaCode371 {
	public static void main(String[] args) {
		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		} catch (Exception e) {
			System.out.println("Parent Exception occurs");
		}
		System.out.println("rest of the code");
	}
}

package com.oops;

/* W.A.J. P to demonstrate try catch block, take two numbers from the user by 
   Command line argument and perform the division operation and handle Arithmetic  
   O/P- 
   Exception in thread main java. Lang. Arithmetic Exception:/ by zero*/

public class ModlCoreJavaCode38 {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]); // first arguments.
		int y = Integer.parseInt(args[1]); // second arguments.
		try {
			double result = x / y;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception occurs");
		}
	}
}

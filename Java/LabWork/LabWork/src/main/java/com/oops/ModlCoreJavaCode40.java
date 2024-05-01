package com.oops;

import java.util.Scanner;

/* W.A.J.P to create a custom exception if Customer withdraw amount which is greater 
than account balance then program will show custom exception otherwise amount 
will deduct from account balance. Account balance is: 2000 Enter withdraw amount: 
2500 */

@SuppressWarnings("serial")
class MyException extends Exception {
	public MyException(String s) {
		super(s);
	}
}

public class ModlCoreJavaCode40 {
	public static void main(String[] args) {

		int amount = -1;
		int balance = 2000;
		
		Scanner sc = new Scanner(System.in);
		while (amount <= 0) {
			System.out.println("Enter withdrawal amount : ");
			amount = sc.nextInt();
		}
		try {
			if (amount > balance) {
				throw new MyException("Sorry insufficient balance. Add Rs. " + (amount - balance) + " to perform this transaction.");
			} else {
				throw new MyException("Withdrawal complete...");
			}
		} catch (MyException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

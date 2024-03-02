package com.exception;

import java.util.Scanner;

class FundException extends Exception {
	double amount;

	public FundException(double amount) {
		this.amount = amount;
	}
}

class ATM {
	double balance;

	public void deposit(double amount) {
		balance += amount;
		System.out.println(amount + " Deposit complete...");
	}

	public void widhtrawal(double amount) throws FundException {
		if (amount <= balance) {
			balance -= amount;
			System.out.println(amount + "Withdraw complete..FundException.");
		} else {
			double needs = amount - balance;
			throw new FundException(needs);
		}
	}
}

public class UserDefineException {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ATM a1 = new ATM();
		System.out.println("Deposit amt :");
		double amount = sc.nextDouble();
		a1.deposit(amount);

		System.out.println("Withdraw amount :");
		amount = sc.nextDouble();
		try {
			a1.widhtrawal(amount);
		} catch (FundException e) {
			System.out.println("You need to deposit " + e.amount + "To withdraw" + amount);
		}
	}
}

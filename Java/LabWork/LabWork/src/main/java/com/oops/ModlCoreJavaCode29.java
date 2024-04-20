package com.oops;

/* Create an abstract class 'Bank' with an abstract method 'getBalance'. $100, $150 and $200 are deposited in banks A, B and C respectively. 
   'BankA', 'BankB' and 'BankC' are subclasses of class 'Bank', each having a method named 'getBalance'. Call this method by creating an 
   object of each of the three classes.*/

abstract class Bank {
	
}

class BankA extends Bank {
	int balance = 0 ;
	void Deposit(int Amount) {
		balance = balance + Amount ;
	}
	
	int getBalance() {
		return balance;
	}
}

class BankB extends Bank {
	int balance = 0 ;
	void Deposit(int Amount) {
		balance = balance + Amount ;
	}
}
class BankC extends Bank {
	int balance = 0 ;
	void Deposit(int Amount) {
		balance = balance + Amount ;
	}
}

public class ModlCoreJavaCode29 {
	public static void main(String[] args) {

		BankA objBankA = new BankA();
		BankB objBankB = new BankB();
		BankC objBankC = new BankC();

//		objBankA = new BankA();

	}
}

package com.oops;

/* Create an abstract class 'Parent' with a method 'message'. It has two subclasses each having a method with the same name 'message' 
 * that prints "This is first subclass" and "This is second subclass" respectively. Call the methods 'message' by creating an object 
 * for each subclass. */

abstract class Prnt {
	void message() {
		System.out.println("This is a parent class.");
	}
}

class subClass1 extends Prnt {
	void message() {
		System.out.println("This is a first subclass.");		
	}
}

class subClass2 extends Prnt {
	void message() {
		System.out.println("This is a second subclass.");		
	}
}

public class ModlCoreJavaCode28 {
	public static void main(String[] args) {

		subClass1 objSC1 = new subClass1();
		subClass2 objSC2 = new subClass2();
		
		objSC1.message();
		objSC2.message();
	}
}

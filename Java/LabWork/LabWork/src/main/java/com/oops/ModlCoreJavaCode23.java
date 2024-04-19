package com.oops;

/* Create a class with a method that prints "This is a parent class" and its subclass with another method that prints "This is child class". 
   Now, create an object for each of the class and call' 
   1 - method of parent class by object of parent class 
   2 - method of child class by object of child class 
   3 - method of parent class by object of child class  */

class fourWheeler
{
	void func4Wheeler()
	{
		System.out.println("This is a parent class.");
	}
}

class brands extends fourWheeler
{
	void funcBrands()
	{
		System.out.println("This is child class");
	}
}

public class ModlCoreJavaCode23 {
	public static void main(String[] args) {
		
		fourWheeler obj4Wheeler = new fourWheeler();
		brands objBrands = new brands();
		
		obj4Wheeler.func4Wheeler();
		objBrands.funcBrands();
		objBrands.func4Wheeler();
	}
}

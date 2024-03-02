package com.oops;

class Sum {
	public Sum() // Default
	{
		int x = 20;
		int y = 10;
		System.out.println("First sum = " + (x+y));
	}

	public Sum(int a) // Parameterized
	{
		int x = a;
		int y = 10;
		System.out.println("Second sum = " + (x+y));
	}

	public Sum(int a, int b) // Parameterized
	{
		int x = a;
		int y = b;
		System.out.println("Second sum = " + (x+y));
	}
}

public class ConstructorDemo {
	public static void main(String[] args) {
		
//		Sum sm1 = new Sum();
//		Sum sm2 = new Sum(20);
//		Sum sm3 = new Sum(20, 10);

		new Sum();
		new Sum(20);
		new Sum(20, 10);
	}
}

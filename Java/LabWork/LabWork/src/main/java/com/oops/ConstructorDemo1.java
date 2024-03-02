package com.oops;
class Sum
{
	int x, y;
	public Sum() // Default
	{
		x = 10;
		y = 20;
		System.out.println("First sum is "+(x+y));
	}
	public Sum(int a) // Parameterized
	{
		x = a;
		y = 20;
		System.out.println("Second sum is "+(x+y));
	}
	public Sum(int a, int b) // Default
	{
		x = a;
		y = b;
		System.out.println("Third sum is "+(x+y));
	}
}
public class ConstructorDemo1 {
public static void main(String[] args) {
	Sum s1=new Sum();
	new Sum(25);
	new Sum(50, 60);
}
}

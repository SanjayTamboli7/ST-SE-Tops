package com.oops;
class Sum1
{
	int x, y;
	public Sum1() // Default
	{
		x = 10;
		y = 20;
		System.out.println("First sum is "+(x+y));
	}
	public Sum1(int a) // Parameterized
	{
		x = a;
		y = 20;
		System.out.println("Second sum is "+(x+y));
	}
	public Sum1(int a, int b) // Default
	{
		x = a;
		y = b;
		System.out.println("Third sum is "+(x+y));
	}
}
public class ConstructorDemo1 {
public static void main(String[] args) {
	Sum1 s1=new Sum1();
	new Sum1(25);
	new Sum1(50, 60);
}
}

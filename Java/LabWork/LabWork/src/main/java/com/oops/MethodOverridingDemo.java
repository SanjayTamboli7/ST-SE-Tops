package com.oops;

class First
{
	public void display()
	{
		System.out.println("This is first class...");
	}
}

class Second extends First
{
	public void display()
	{
		System.out.println("This is second class..");
	}
}
public class MethodOverridingDemo {
public static void main(String[] args) {
	{
		Second s1=new Second();
		s1.display();
		
		First f1=new First();
		f1.display();
		f1=new Second();
		f1.display();
	}
}
}

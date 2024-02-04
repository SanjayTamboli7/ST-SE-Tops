package com.oops;

class Student 
{
	private int sno = 1;
	String sname = "tops", city = "CGRoad";
	private void assignDataValue()
	{
		sno = 123;
		sname="Sanjay";
		city = "Ahmedabad";
	}
	public void display()
	{
		assignDataValue();
		System.out.println("Sno = "+sno);
		System.out.println("Sname = "+sname);
		System.out.println("City = "+city);
	}
}
public class ClassDemo2 {
	public static void main(String[] args)
	{
		Student s1 = new Student();
		s1.display();
	}
}

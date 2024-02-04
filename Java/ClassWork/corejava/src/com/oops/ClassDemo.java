package com.oops;
class Employee
{
	int salary, da, hra, pf, netsal;
	String ename;

	public void setData()
	{
		ename = "Sanjay";
		salary = 123456;
		da = 1234;
		hra = 4321;
		pf = 10000;
	}
	private int calcSalary()
	{
		netsal = salary + da + hra + pf;
		return netsal;
	}
	public void display()
	{
		System.out.println("Ename = " + ename);
		System.out.println("Salary = " + salary);
		System.out.println("DA = " + da );
		System.out.println("HRA = " + hra );
		System.out.println("PF = " + pf );
		System.out.println("Net Salary = " + calcSalary());
	}
}
public class ClassDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setData();
		e1.display();
	}
}

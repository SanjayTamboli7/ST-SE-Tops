package com.oops;

class Student1
{
	
public Student1()
{
	System.out.println("This is Student class...");
}

int sno;
String sname;

public void setStudentData() {
	sno = 123;
	sname = "Rahul";
}
}

class Sport1 extends Student1 // Sport1 is child class
{
public Sport1() {
	// super()

	System.out.println("This is sport class...");

}

String spname;

public void setSportData() {
	spname = "Cricket";

}
}
class Result1 extends Sport1
{
public Result1()
{
	System.out.println("This is result class");
}
String grade;
public void setResultData()
{
	grade = "A+";
}
public void display()
{
	System.out.println("Sno = "+sno);
	System.out.println("sname = "+sname);
	System.out.println("Sport name = "+spname);
	System.out.println("grade = "+grade);
}
}

public class InheritanceDemo {
public static void main(String[] args) {


//	public class InheritanceDemo {
//		public static void main(String[] args) {
			Result1 s1 = new Result1();
			s1.setStudentData();
			s1.setSportData();
			s1.setResultData();
			s1.display();
		}
	}

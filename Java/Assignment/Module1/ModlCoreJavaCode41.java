package com.oops;

/* W.A.J.P to create a class Student with attributes roll no, name, age and course. 
Initialize values through parameterized constructor. 
If age of student is not in between 15 and 21 then generate user defined exception "AgeNotWithinRangeException". 
If name contains numbers or special symbols raise exception "NameNotValidException". 
Define the two exception classes. */

@SuppressWarnings("serial")
class AgeNotWithinRangeException extends Exception {
	public AgeNotWithinRangeException(String s) {
		super(s);
	}
}

@SuppressWarnings("serial")
class NameNotValidException extends Exception {
	public NameNotValidException(String s) {
		super(s);
	}
}

class Student {

	int rollNo;
	String name;
	int age;
	String course;

	Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.course = course;

		System.out.println(" Roll No : " + this.rollNo);
		System.out.println("    Name : " + this.name);
		System.out.println("     Age : " + this.age);
		System.out.println("  Course : " + this.course);

		if (this.age < 15 || this.age > 21) {
			throw new AgeNotWithinRangeException("Valid age is between 15 and 21.");
		}
		
		char[] charArray = this.name.toCharArray();
		for (char c : charArray) {
			int ascValue = (int) c;
			if (ascValue < 65 || ascValue > 122) {
				throw new NameNotValidException("Name should have a-z or A-Z characters.");
			}
			if (ascValue < 97 && ascValue > 90) {
				throw new NameNotValidException("Name should have a-z or A-Z characters.");
			}
		}
	}
}

public class ModlCoreJavaCode41 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Student objStudent = new Student(596, "SanjayTamboli", 20, "Javafullstack");
		} catch (AgeNotWithinRangeException | NameNotValidException e) {
			e.printStackTrace();
		}
		try {
			Student objStudent1 = new Student(597, "SanjayKapdi", 14, "MERNstack");
		} catch (AgeNotWithinRangeException | NameNotValidException e) {
			e.printStackTrace();
		}
		try {
			Student objStudent2 = new Student(598, "SanjayPanwala", 59, "MEANfullstack");
		} catch (AgeNotWithinRangeException | NameNotValidException e) {
			e.printStackTrace();
		}
		try {
			Student objStudent3 = new Student(599, "SanjayMehta!2", 18, "WebDesign");
		} catch (AgeNotWithinRangeException | NameNotValidException e) {
			e.printStackTrace();
		}
	}
}

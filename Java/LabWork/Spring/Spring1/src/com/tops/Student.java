package com.tops;

public class Student {

	private String sname, subject, grade;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void display() {
		System.out.println("   Name : " + sname);
		System.out.println("Subject : " + subject);
		System.out.println("  Grade : " + grade);
	}
}

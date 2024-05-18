package com.oops;

/* Create a class named 'Member' having the following members:  
1. Data members 
2. Name 
3. Age 
4. Phone number 
5. Address 
6. Salary 
It also has a method named 'printSalary' which prints the salary of the members.  */

class Member
{
	String Name ; 
	int Age ; 
	long Phonenumber ;	
	String Addressl ;
	int Salary ;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public long getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		Phonenumber = phonenumber;
	}
	public String getAddressl() {
		return Addressl;
	}
	public void setAddressl(String addressl) {
		Addressl = addressl;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}	
}

public class ModlCoreJavaCode24 {
	public static void main(String[] args) {
		
		Member objMember = new Member();
		
		objMember.setName("Sanjay Tamboli");
		objMember.setAge(59);
		objMember.setPhonenumber(982543478);
		objMember.setAddressl("A-904, Shivalay Height, Stadium Rd, Motera, Ahmedabad");
		objMember.setSalary(123456);
		
		System.out.println("    Name : " + objMember.getName());
		System.out.println("     Age : " + objMember.getAge());
		System.out.println("   Phone : " + objMember.getPhonenumber());
		System.out.println(" Address : " + objMember.getAddressl());
		System.out.println("  Salary : " + objMember.getSalary());
				
	}
}

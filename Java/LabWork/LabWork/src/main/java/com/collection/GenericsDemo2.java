package com.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsDemo2 {
	public static void main(String[] args) {
		ArrayList<Student> a1 = new ArrayList<Student>();

		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Rahul");
		s1.setCity("S.Nagar");

		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("Rocky");
		s2.setCity("G.Nagar");
		
		a1.add(s1);
		a1.add(s2);
		System.out.println("1 Size = " + a1.size());
		System.out.println("1 Value = " + a1);

		Iterator<Student> i1=a1.iterator();
		
		while(i1.hasNext()) {
			Student s=i1.next();
			System.out.println("Sid = " + s.getSid());
			System.out.println("Sname = " + s.getSname());
			System.out.println("City = " + s.getCity());
			System.out.println("");
		}
		
		Iterator i2=a1.iterator();
		
		while(i2.hasNext()) {
			Student s=(Student)i2.next();
			System.out.println("Sid = " + s.getSid());
			System.out.println("Sname = " + s.getSname());
			System.out.println("City = " + s.getCity());
			System.out.println("");
		}
	}
}

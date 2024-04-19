package com.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Vector<Comparable> v1 = new Vector<Comparable>();
		v1.add(100);
		v1.add(45.46f);
		v1.add('T');
		v1.add(new Integer(123));
		System.out.println("Size 1 = " + v1.size());
		System.out.println("Value 1 = " + v1);
		System.out.println("Capacity 1 = " + v1.capacity());
		v1.add("Rahul");
		System.out.println("Size 2 = " + v1.size());
		System.out.println("Value 2 = " + v1);
		System.out.println("Capacity 2 = " + v1.capacity());
		v1.remove(0);
		System.out.println("Size 3 = " + v1.size());
		System.out.println("Value 3 = " + v1);
		System.out.println("Capacity 3 = " + v1.capacity());
		v1.remove("Rahul");
		System.out.println("Size 4 = " + v1.size());
		System.out.println("Value 4 = " + v1);
		System.out.println("Capacity 4 = " + v1.capacity());

		Iterator i1 = v1.iterator();
		while (i1.hasNext()) {
				System.out.println(i1.next());
				
		}
		
		Enumeration e1 = v1.elements();
		while(e1.hasMoreElements()) {
			System.out.println(e1.nextElement());
		}

	}
}

package com.collection;

import java.util.ArrayList;

public class ArrayListDemo {
	@SuppressWarnings({ "unchecked", "removal" })
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ArrayList a1 = new ArrayList() ;
		System.out.println("Size 1 = " + a1.size());
		System.out.println("Value 1 = " + a1);		
		a1.add("Rahul");
		a1.add(100);
		a1.add(45.46f);
		a1.add('T') ;
		a1.add(new Integer(123)) ;
		System.out.println("Size 2 = " + a1.size());
		System.out.println("Value 2 = " + a1);
		a1.remove(3);
		System.out.println("Size 3 = " + a1.size());
		System.out.println("Value 3 = " + a1);
		a1.remove("Rahul") ;
		System.out.println("Size 4 = " + a1.size());
		System.out.println("Value 4 = " + a1);
	}
}

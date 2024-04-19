package com.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashSet h1 = new HashSet();
		System.out.println("Default size = " + h1.size());
		System.out.println("Default value = " + h1);
		h1.add(100);
		h1.add("Rahul");
		h1.add(45.65f);
		h1.add('T');
		h1.add(new Integer(123));
		System.out.println("Default size = " + h1.size());
		System.out.println("Default value = " + h1);
		h1.add("rahul");
		System.out.println("Default size = " + h1.size());
		System.out.println("Default value = " + h1);
		h1.remove("rahul");
		System.out.println("Default size = " + h1.size());
		System.out.println("Default value = " + h1);
		Iterator i1 = h1.iterator();
		while (i1.hasNext()) {
			System.out.println(i1.next());
		}
	}
}

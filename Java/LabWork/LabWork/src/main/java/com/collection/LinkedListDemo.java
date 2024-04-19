package com.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<String> al = new LinkedList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Kavi");
		al.add("Ajay");
		System.out.println(" Size 1 = " + al.size());
		System.out.println("Value 1 = " + al);
		al.addLast("Sanjay");
		System.out.println(" Size 2 = " + al.size());
		System.out.println("Value 2 = " + al);
		al.remove(3);
		System.out.println(" Size 3 = " + al.size());
		System.out.println("Value 3 = " + al);
		al.remove("Ravi");
		System.out.println(" Size 4 = " + al.size());
		System.out.println("Value 4 = " + al);
		al.removeFirst();
		System.out.println(" Size 5 = " + al.size());
		System.out.println("Value 5 = " + al);
		al.removeLast();
		System.out.println(" Size 6 = " + al.size());
		System.out.println("Value 6 = " + al);
		al.add("Ravi");
		System.out.println(" Size 7 = " + al.size());
		System.out.println("Value 7 = " + al);
		al.add("Vijay");
		System.out.println(" Size 8 = " + al.size());
		System.out.println("Value 8 = " + al);
		al.add("Ajay");
		Iterator<String> il = al.iterator();
		while (il.hasNext()) {
			System.out.println(il.next());
		}
	}
}

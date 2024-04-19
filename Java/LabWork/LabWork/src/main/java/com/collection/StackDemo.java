package com.collection;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack s1 = new Stack();
		System.out.println("Defailt size = " + s1.size());
		System.out.println("Defailt value = " + s1);
		s1.push("Rahul");
		s1.push(123);
		s1.push('T');
		System.out.println("Defailt size = " + s1.size());
		System.out.println("Defailt value = " + s1);
		s1.add(45.65f);
		s1.add(new Integer(100));
		System.out.println("Defailt size = " + s1.size());
		System.out.println("Defailt value = " + s1);
		s1.remove(0);
		System.out.println("Defailt size = " + s1.size());
		System.out.println("Defailt value = " + s1);
		s1.pop();
		System.out.println("Defailt size = " + s1.size());
		System.out.println("Defailt value = " + s1);
		Iterator i1 = s1.iterator();
		while (i1.hasNext()) {
				System.out.println(i1.next());
				
		}
	}
}

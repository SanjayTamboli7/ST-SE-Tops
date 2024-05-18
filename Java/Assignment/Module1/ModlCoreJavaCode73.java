package com.oops;

/* Write a Java program to compare two sets and retain elements which are same on both sets. */

import java.util.ArrayList;

public class ModlCoreJavaCode73 {
	public static void main(String[] args) {

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(4);

		System.out.println("Original List:" + list1);

		System.out.println("List containing elements to be retained by the calling collection:" + list2);

		// Retains(or keep) only those elements which are specified inside the
		// collection
		boolean modified = list1.retainAll(list2);

		System.out.println("Calling Collection Modified: " + modified);
		System.out.println("Original List(Elements Retained):" + list1);
	}
}

package com.collection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println("" + d1.getDay());
		System.out.println("" + d1.getMonth());
		System.out.println("" + d1.getDate());
		System.out.println("" + d1.getYear());
		SimpleDateFormat s1 = new SimpleDateFormat("dd/mm/yyyy"); // Try various combination here
		System.out.println(s1.format(d1));
	}
}

package com.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Scanner;

/* W.A.J.P to find the second most frequent character in a given string. The given string is: 
   successes The second most frequent char in the string is: c   */

public class ModlCoreJavaCode19 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			System.out.print("Enter a string: ");
			String str = sc.nextLine(); // reads string
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			str = new String(ch);
			ArrayList<String> strArray = new ArrayList<>();
			char strChar1 ;
			char strCharp = 0 ;
			ArrayList<Integer> ctrArray = new ArrayList<Integer>();
			int ctrChar = 0;
			for (int ctr = 0; ctr <= str.length() - 1; ctr++) {
				strChar1 = str.charAt(ctr);
				if (ctr==0) {
					strCharp = strChar1;
				}
				boolean charFound = false;
				ListIterator<String> iterator = strArray.listIterator();
				while (iterator.hasNext()) {
					if (iterator.next().equals(Character.toString(strChar1))) {
						charFound = true;
						break;
					}
				}
				if (strCharp == strChar1) {
					ctrChar = ctrChar + 1;
				}
				else {
					ctrArray.add(ctrChar);
					ctrChar = 1;
					strCharp = strChar1;
				}
				if (!charFound) {
					strArray.add(Character.toString(strChar1));
				}
			}
			ctrArray.add(ctrChar);
			System.out.println("Array is = " + strArray);
			System.out.println("Count is = " + ctrArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package module1;

import java.util.Scanner;

/* Write a Java program to count the letters, spaces, numbers and other characters of  an input string.  */

public class ModlCoreJavaCode08 {
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			System.out.print("Enter a string: ");
			String str = sc.nextLine(); // reads string
			for (int ctr=0; ctr<=str.length();ctr++) {
				System.out.print(str.substring(ctr, ctr+1));
			}
			System.out.print("You have entered: " + str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

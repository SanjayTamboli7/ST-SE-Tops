package com.oops;

import java.util.Scanner;

/* Create a class to print the area of a square and a rectangle. The class has two methods with the same name but different number of 
 * parameters. The method for printing  area of a rectangle has two parameters which are length and breadth respectively  while the other 
 * method for printing area of square has one parameter which is side of square. */
class area {
	public int findArea(int l, int w) {
		return l * w ;
	}
		
	public int findArea(int s) {
		return s * s;
	}
}

public class ModlCoreJavaCode22 {
	public static void main(String[] args) {

		area ar = new area() ;
		Scanner sc = new Scanner(System.in);
		char c = 0 ;
		while (true) {
			System.out.print("Enter S for Square or R for Rectangle: ");  
			c = sc.next().charAt(0);
			if (c == 'S' || c == 'R') {
				break;
			}
		}		
		switch(c) {
		case 'S':
			System.out.println("Enter side Length : ");
			int s = sc.nextInt();
			System.out.println("Square area = "+ ar.findArea(s));
			break;
		case 'R':
			System.out.println("Enter Length : ");
			int l = sc.nextInt();
			System.out.println("Enter Width : ");
			int w = sc.nextInt();
			System.out.println("Rectangle area = "+ ar.findArea(l, w));
			break;
		default: 
			System.out.println("Valid input is either S or R");
		}
	}
}

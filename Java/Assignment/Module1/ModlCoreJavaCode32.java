package com.oops;

import java.util.Scanner;

/* We have to calculate the area of a rectangle, a square and a circle. 

Create an abstract class 'Shape' with three abstract methods namely 'RectangleArea' taking two parameters, 'SquareArea' and 
'CircleArea' taking one parameter each. 

The parameters of 'RectangleArea' are its length and breadth, that of 'SquareArea' is its side and that of 'CircleArea' is its 
radius. 

Now, create another class 'Area' containing all the three methods 'RectangleArea', 'SquareArea' and 'CircleArea' for printing the 
area of rectangle, square and circle respectively. 

Create an object of class 'Area' and call all the three methods. */

abstract class Shape {
	abstract double RectangleArea(double langth, double breadth);
	abstract double SquareArea(double side);
	abstract double CircleArea(double radius);
}

class clsArea extends Shape {
		
	double RectangleArea(double langth, double breadth) {
		return langth * breadth;
	}	

	double SquareArea(double side) {
		return side * side ;
	}
	
	double CircleArea(double radius) {
		return 3.14 * radius * radius;
	}
}

public class ModlCoreJavaCode32 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double langth = -1;
		double breadth = -1;
		double side = -1;
		double radius = -1;
		
		while (langth <= 0) {
			System.out.println("Enter Rectangle Length : ");  
			langth = sc.nextDouble();
		}
		
		while (breadth <= 0) {
			System.out.println("Enter Rectangle breadth : ");  
			breadth = sc.nextDouble();
		}
		
		while (side <= 0) {
			System.out.println("Enter Square side : ");  
			side = sc.nextDouble();
		}		

		while (radius <= 0) {
			System.out.println("Enter Circle radius : ");  
			radius = sc.nextDouble();
		}
		
		clsArea objArea = new clsArea();
		System.out.println("Rectamgle Area = " + objArea.RectangleArea(langth, breadth));
		System.out.println("   Square Area = " + objArea.SquareArea(side));		
		System.out.println("   Circle Area = " + objArea.CircleArea(radius));		
	}
}

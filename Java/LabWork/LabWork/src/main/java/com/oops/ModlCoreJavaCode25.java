package com.oops;

/* Create a class named 'Rectangle' with two data members 'length' and 'breadth' and two methods to print the area and parameter of the 
   rectangle respectively. 
   Its constructor having parameters for length and breadth is used to initialize the length and breadth of the rectangle. 
   Let class 'Square' inherit the 'Rectangle' class with its constructor having a parameter for its side (suppose s) calling the constructor 
   of its parent class as 'super (s, s)'. 
   Print the area and parameter of a rectangle and a square. */

class Rectangle {
	int lenth;
	int breadth;

	Rectangle(int l, int b) {
		lenth = l;
		breadth = b;
	}

	void printvalues() {
		System.out.println("  length : " + lenth);
		System.out.println(" breadth : " + breadth);
	}

	void printArea() {
		System.out.println(" Area = " + (lenth * breadth));
	}
}

class Square extends Rectangle {
	Square(int s) {
		super(s, s);
		System.out.println("You are in square class.");
	}
}

public class ModlCoreJavaCode25 {
	public static void main(String[] args) {

		Rectangle objRectangle = new Rectangle(5, 5);
		objRectangle.printvalues();
		objRectangle.printArea();
		System.out.println("------------------------");
		Square objSquare = new Square(6);
		objSquare.printvalues();
		objSquare.printArea();
	}
}

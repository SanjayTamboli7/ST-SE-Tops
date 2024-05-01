package com.oops;

/*  
Create a class named 'Shape' with a method to print "This is this is shape". 

Create two other classes named 'Rectangle', 'Circle' inheriting the Shape class, both having a method to print 
"This is rectangular shape" and "This is circular shape" respectively. 

Create a subclass 'Square' of 'Rectangle' having a method to print "Square is a rectangle". 

Now, call the method of 'Shape' and 'Rectangle' class by the object of 'Square' class. */

class Shepe {
	void Shepe1() {
		System.out.println("This is Shape.");
	}
}

class RactAngle extends Shepe {
	void RactAngle1() {
		System.out.println("This is rectangular shape.");
	}
}

class Circle extends Shepe {
	void Circle1() {
		System.out.println("This is circular shape.");
	}
}

class Sqr extends RactAngle {
	void Square1() {
		System.out.println("Square is a rectangle.");
	}
}

public class ModlCoreJavaCode34 {
	public static void main(String[] args) {
		Sqr objSquare = new Sqr();
		objSquare.Shepe1();
		objSquare.RactAngle1();
	}
}

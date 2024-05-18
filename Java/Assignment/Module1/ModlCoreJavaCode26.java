package com.oops;

/* Write a program to print the area and parameter of a triangle having sides of 3, 4 and 5 
   units by creating a class named 'Triangle' without any parameter in its constructor.  */

class Triangle {

	int sidea, sideb, sidec ;
	
	void setValues( int a, int b, int c ) {
		sidea = a; 
		sideb = b; 
		sidec = c;
	}
	
	void printValues() {
	 System.out.println("Side a = " + sidea);	
	 System.out.println("Side b = " + sideb);	
	 System.out.println("Side c = " + sidec);	
	}
	
	double Area() {
		
		float height ;		
		double TArea = 0;
		
		height = (sidea * sideb) / sidec ;
		TArea = (0.5) * sidec * height;
		
		return TArea;
	}	
}

public class ModlCoreJavaCode26 {
	public static void main(String[] args) {
		Triangle objTriangle = new Triangle();
		objTriangle.setValues(3, 5, 7);
		objTriangle.printValues();
		System.out.println("  Area = "+ objTriangle.Area());
	}
}

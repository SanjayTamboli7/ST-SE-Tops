package com.oops;

import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.IntStream;

/* We have to calculate the percentage of marks obtained in three subjects (each out of 100) by student A and in four subjects 
   (each out of 100) by student B. Create an abstract class 'Marks' with an abstract method 'getPercentage'. It is inherited by 
   two other classes 'A' and 'B' each having a method with the same name which returns the percentage of the students. 
   
   The constructor of student A takes the marks in three subjects as its parameters and the marks in four subjects as its parameters 
   for student B. Create an object for each of the two classes and print the percentage of marks for both the students. */

abstract class Marks {
	abstract double getPercentage();
}

class MarksA extends Marks {

	int biologyMarks, physicsMarks, chemistryMarks;	
	
	MarksA (int bioMarks, int phyMarks, int chemMarks) {
		biologyMarks   = bioMarks ;
		physicsMarks   = phyMarks ;
		chemistryMarks = chemMarks ;
	}
	
	double getPercentage() {
		
		double result = -1;
		
		IntStream stream = IntStream.of(biologyMarks, physicsMarks, chemistryMarks) ;
		OptionalDouble obj = stream.average();
		
        if (obj.isPresent()) {
            result = obj.getAsDouble();
        }
        return result ;
	}
}

class MarksB extends Marks {

	int biologyMarks, physicsMarks, chemistryMarks, mathsMarks;	
	
	MarksB (int bioMarks, int phyMarks, int chemMarks, int mathMarks ) {
		biologyMarks   = bioMarks ;
		physicsMarks   = phyMarks ;
		chemistryMarks = chemMarks ;
		mathsMarks     = mathMarks ;
	}
	
	double getPercentage() {
		
		double result = -1;
		
		IntStream stream = IntStream.of(biologyMarks, physicsMarks, chemistryMarks, mathsMarks) ;
		OptionalDouble obj = stream.average();
		
        if (obj.isPresent()) {
//            System.out.println(obj.getAsDouble());
            result = obj.getAsDouble();
        }
        return result ;
	}
}

public class ModlCoreJavaCode30 {
	public static void main(String[] args) {
		
		int bioMark,  phyMark,  chemMark, mathMark ;
		
		Scanner sc = new Scanner(System.in) ;
		System.out.println("  Student A Biology Marks : ");
		bioMark = sc.nextInt();
		System.out.println("  Student A Physics Marks : ");
		phyMark = sc.nextInt();
		System.out.println("Student A Chemistry Marks : ");
		chemMark = sc.nextInt();
		MarksA objMarksA = new MarksA(bioMark,  phyMark,  chemMark);
		System.out.println(" Student A Average Marks = " + objMarksA.getPercentage());

		System.out.println("");
		System.out.println("  Student B Biology Marks : ");
		bioMark = sc.nextInt();
		System.out.println("  Student B Physics Marks : ");
		phyMark = sc.nextInt();
		System.out.println("Student B Chemistry Marks : ");
		chemMark = sc.nextInt();
		System.out.println("    Student B Maths Marks : ");
		mathMark = sc.nextInt();
		MarksB objMarksB = new MarksB(bioMark,  phyMark,  chemMark, mathMark);
		System.out.println(" Student B Average Marks = " + objMarksB.getPercentage());
	}
}

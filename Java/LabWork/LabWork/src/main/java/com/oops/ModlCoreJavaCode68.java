package com.oops;

/* Write a Java program to convert a hash set to a List/Array List. */

import java.util.ArrayList;
import java.util.HashSet;

public class ModlCoreJavaCode68 {
	public static void main(String[] args) {

        HashSet<String> flower_set = new HashSet<>();
        
        flower_set.add("tulip");
        flower_set.add("rose");
        flower_set.add("orchid");
        flower_set.add("marie-gold");
 
        System.out.println("Elements of flower Hashset are : " + flower_set);
        
        // Pass hash set to array list constructor
        ArrayList<String> flower_array = new ArrayList<>(flower_set);
 
        // all elements from hash set are copied to array list
        System.out.println("Elements of flower Arraylist are : " + flower_array);
 
	}
}

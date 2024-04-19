package com.oops;

import java.util.Arrays;
import java.util.Collections;

public class Temporary {
	public static void main(String[] args) {
        String[] strings = {"apple", "banana", "cherry", "date"};
        
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, Collections.reverseOrder());
        Arrays.sort(strings, Collections.reverseOrder());
        

        System.out.println("After sorting in descending order:");
        System.out.println(Arrays.toString(strings));
	}
}

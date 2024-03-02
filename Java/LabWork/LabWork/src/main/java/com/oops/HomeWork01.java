package com.oops;

import java.util.Scanner;

public class HomeWork01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of elements: ");

		int r = sc.nextInt();
		int[]a = new int[r];
		int maxNo1 = 0;
		int maxNo2 = 1;
		int minNo1 = 999;
		int minNo2 = 998;


		for (int i = 0; i < r; i++) 
		{
			
			System.out.print("Enter value for a[" + i + 1 + "] : ");
			int c = sc.nextInt();
//			a[i] = new int[c];
			a[i] = c;
			if (a[i] > maxNo1) {				
				maxNo1 = a[i] ; 
			}
			if (maxNo2 > maxNo1) {
				maxNo2 = maxNo1 ;
			}
			if (a[i] < minNo1) {
				minNo1 = a[i] ; 
			}
			if (minNo2 < minNo1) {
				minNo2 = minNo1;
			}
		}

		// Logic to sort array in ascending
		// Logic to sort array in descending

		System.out.println("First Maximum  : " + maxNo1);
		System.out.println("Second Maximum : " + maxNo2);
		System.out.println("First Minimum  : " + minNo1);
		System.out.println("Second Minimum : " + minNo2);
	}
}

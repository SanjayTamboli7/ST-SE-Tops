package com.oops;

import java.util.Scanner;

public class JaggedArray2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Enter number of row : "); ;
		int r=sc.nextInt();
		int [][] a = new int[r][];
		
		for (int i=0;i<r;i++) {
			System.out.println("Enter number of columns for row " + i + " : " );
			int c = sc.nextInt();
			a[i] = new int[c] ;
		}
		for (int i=0;i<r;r++) {
			for (int j=0;j<a[i].length;j++) {
				a[i][j]= j+1;
				System.out.print( a[i][j] + " ");
			}
			System.out.println();
		}
	}
}

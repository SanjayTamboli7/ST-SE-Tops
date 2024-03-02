package com.oops;

public class ArrayDemo2 {
	public static void main(String[] args) {

		int[][] a = new int[3][3];
		int[][] b = new int[3][3];
		int[][] c = new int[3][3];
		int[][] d = new int[3][3];
		int[][] m = new int[3][3];
		int[][] s = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = (i + j+1) * 2;
				b[i][j] = (i + j+1) * 3;
				c[i][j] = a[i][j] + b[i][j];
				m[i][j] = a[i][j] * b[i][j];
				d[i][j] = a[i][j] / b[i][j];
				s[i][j] = a[i][j] - b[i][j];
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Add");		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Substract");		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Multiply");		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	
		System.out.println("Divide");		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}

	}
}

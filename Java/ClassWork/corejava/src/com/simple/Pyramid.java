package com.simple;

public class Pyramid {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			System.out.println();
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
		}
		System.out.println();
		for (int i = 4; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		for (int i = 1; i <= 5; i++) {
			System.out.println();
			for (int j = 1; j <= i; j++) {
				if (j%2==0) {System.out.print("*");}
				else {System.out.print("$");}
			}
		}
	}
}

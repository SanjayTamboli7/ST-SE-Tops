package com.oops;

public class JaggedArray1 {
public static void main(String[] args) {
	int[][] a=new int[3][];
	a[0]=new int[5];
	a[1]=new int[3];
	a[2]=new int[4];
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < a[i].length; j++) {
			a[i][j] = i+j+1;
			System.out.print(a[i][j]);
		}
		System.out.println();
	}
	
}
}

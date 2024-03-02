package com.oops;

class Addition {
	int x, y;

	public void sum() {
		x = 10;
		y = 20;
		System.out.println("First sum = " + (x + y));
	}

	public void sum(int a) {
		x = y = a;
		System.out.println("Second sum = " + (x + y));
	}

	public void sum(float f) {
		x = y = (int) f;
		System.out.println("Float sum = " + (x + y));
	}

	public void sum(int a, int b) {
		x = a;
		y = b;
		System.out.println("Third sum = " + (x + y));
	}

}

public class MehodOverloadingDemo {
	public static void main(String[] args) {
		Addition a1 = new Addition();
		a1.sum();
		a1.sum(123);
		a1.sum(456.65f);
		a1.sum(78, 98);
	}
}

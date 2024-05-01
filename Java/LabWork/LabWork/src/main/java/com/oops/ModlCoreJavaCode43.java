package com.oops;

/* W.A.J.P to create 2 threads and execute that threads by providing sleep time as 2000ms and check the execution.  */

class MyThread1 implements Runnable {
	public void run() {
		System.out.println("Thread one is started!");
	}
}

class MyThread2 implements Runnable {
	public void run() {
		System.out.println("Thread two is started!");
	}
}

public class ModlCoreJavaCode43 {

	public static void main(String[] args) {
		MyThread1 obj1 = new MyThread1();
		Thread t1 = new Thread(obj1);

		MyThread2 obj2 = new MyThread2();
		Thread t2 = new Thread(obj2);

		t1.start();
		try {
			Thread.sleep(200); // miliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(200); // miliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

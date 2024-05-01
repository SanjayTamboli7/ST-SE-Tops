package com.oops;

/* W.A.J.P to create 2 threads and make one thread as Daemon Thread by using set Daemon () method of 
   Thread class and check whether the thread is set daemon or not by using is Daemon () method. */

class MyThread4 implements Runnable {
	static int ctr = 0;

	public void run() {
		ctr++;
		System.out.println("Thread is created " + ctr + " time.");
	}
}

public class ModlCoreJavaCode45 {
	public static void main(String[] args) {
		
		MyThread4 obj1 = new MyThread4();
		Thread t1 = new Thread(obj1);

		MyThread4 obj2 = new MyThread4();
		Thread t2 = new Thread(obj2);

		t1.start();
		t2.start();

	}
}

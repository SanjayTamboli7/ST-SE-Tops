package com.oops;

/* W.A.J.P to start the same Thread twice by calling start () method twice. Test 
ThreadTwice1 t1=new TestThreadTwice1(); t1.start (); t1.start ();  */

class MyThread3 implements Runnable {
	static int ctr = 0;

	public void run() {
		ctr++;
		System.out.println("Thread is created " + ctr + " time.");
	}
}

public class ModlCoreJavaCode44 {
	public static void main(String[] args) {
		MyThread3 obj1 = new MyThread3();
		Thread t1 = new Thread(obj1);

		MyThread3 obj2 = new MyThread3();
		Thread t2 = new Thread(obj2);

		t1.start();
		t2.start();
	}
}

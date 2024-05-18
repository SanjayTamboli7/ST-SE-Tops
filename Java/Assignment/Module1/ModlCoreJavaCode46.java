package com.oops;

/* W.A.J.P to create 2 threads and make one thread as Daemon Thread by using set 
Daemon () method of Thread class and check whether the thread is set daemon or 
not by using is Daemon () method. */

class DaemonThread extends Thread {
	public DaemonThread(String name) {
		super(name);
	}

	public void run() {
		// Checking whether the thread is Daemon or not
		if (Thread.currentThread().isDaemon()) {
			System.out.println(getName() + " is Daemon thread");
		}

		else {
			System.out.println(getName() + " is User thread");
		}
	}
}

class MyThread5 implements Runnable {
	public void run() {
		System.out.println("Thread one is started!");
	}
}

class MyThread6 implements Runnable {
	public void run() {
		System.out.println("Thread two is started!");
	}
}

public class ModlCoreJavaCode46 {
	public static void main(String[] args) {
		MyThread5 obj1 = new MyThread5();
		Thread t1 = new Thread(obj1);

		MyThread6 obj2 = new MyThread6();
		Thread t2 = new Thread(obj2);

		t1.start();
		try {
			Thread.sleep(200); // Milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(200); // Milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		DaemonThread tt1 = new DaemonThread("t1");
		DaemonThread tt2 = new DaemonThread("t2");
		DaemonThread tt3 = new DaemonThread("t3");

		// Setting user thread t1 to Daemon
		tt1.setDaemon(true);

		// starting first 2 threads
		tt1.start();
		tt2.start();

		// Setting user thread t3 to Daemon
		tt3.setDaemon(true);
		tt3.start();
	}
}

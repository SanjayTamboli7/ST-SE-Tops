package com.oops;

/* W.A.J. P to create one thread by implementing Runnable interface in Class. */

class MyThread implements Runnable 
{ 
	
	public void run() 
	{ 
		System.out.println("Thread is created!");
	} 
} 

public class ModlCoreJavaCode42 {
	public static void main(String[] args) {
		MyThread obj=new MyThread(); 
		Thread t=new Thread(obj); 
		t.start();
	}
}

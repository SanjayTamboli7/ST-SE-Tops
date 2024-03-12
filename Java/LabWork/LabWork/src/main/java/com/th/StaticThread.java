package com.th;

public class StaticThread {
public static void main(String[] args) {
	Thread t=Thread.currentThread();
	System.out.println(t);
	t.setName("Sanjay");
	System.out.println(t);
	t.setPriority(Thread.NORM_PRIORITY);
	System.out.println(t);
	System.out.println("Is alive or not..."+t.isAlive());
}
}

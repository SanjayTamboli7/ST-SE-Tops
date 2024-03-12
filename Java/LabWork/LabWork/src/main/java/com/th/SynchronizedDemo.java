package com.th;

class Message {
	public void display(String msg) {
		System.out.print(" [ " + msg);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(" ] ");
	}
}

class Synch extends Thread {
	String msg;
	Message m1;

	public Synch(String msg, Message m1) {
		this.m1 = m1;
		this.msg = msg;
	}

	public void run() {
		synchronized (m1) {
			m1.display(msg);
		}
	}
}

public class SynchronizedDemo {
	public static void main(String[] args) {
		Message m1 = new Message();
		Synch s1 = new Synch("Hello", m1);
		Synch s2 = new Synch("How are you?", m1);
		Synch s3 = new Synch("Have lunch with us", m1);
		s1.start();
		s2.start();
		s3.start();
	}
}

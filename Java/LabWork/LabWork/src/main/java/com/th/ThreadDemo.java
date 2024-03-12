package com.th;

class First extends Thread
{
	public void run()
	{
		for(int i=1; i<=5; i++)
		{
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("My First Thread is..."+i);
		}
		System.out.println("My First Thread is completed...");
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		First f1=new First();
		f1.setName("Rahul");
		f1.setPriority(Thread.MAX_PRIORITY);
		System.out.println(f1);
		f1.start();
		for(int i=1; i<=5; i++)
		{
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("My First Thread is..."+i);
		}
		System.out.println("My First Thread is completed...");
		
	}
}

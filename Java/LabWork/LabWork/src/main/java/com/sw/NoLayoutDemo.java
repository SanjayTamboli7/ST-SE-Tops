package com.sw;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class NDemo
{
	JFrame frame;
	JButton b1, b2, b3, b4;
	
	public NDemo()
	{
		frame = new JFrame("Nolayout Demo");
		frame.setLayout(null);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1=new JButton("Insert");
		b1.setBounds(100, 100, 75, 25);
		b2=new JButton("Update");
		b2.setBounds(180, 100, 75, 25);
		b3=new JButton("Delete");
		b3.setBounds(100, 130, 75, 25);
		b4=new JButton("Display");
		b4.setBounds(180, 130, 85, 25);
				
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
	}
}
public class NoLayoutDemo {
	public static void main(String[] args) {
		new NDemo();
	}
}

package com.sw;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class BDemo
{
	JFrame frame;
	JButton b1, b2, b3, b4, b5;
	public BDemo()
	{		
		frame = new JFrame("Border Demo");
		frame.setLayout(new BorderLayout());
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("North");
		b2 = new JButton("South");
		b3 = new JButton("East");
		b4 = new JButton("West");
		b5 = new JButton("Center");
		frame.add(b1, BorderLayout.NORTH);
		frame.add(b2, BorderLayout.SOUTH);
		frame.add(b3, BorderLayout.EAST);
		frame.add(b4, BorderLayout.WEST);
		frame.add(b5, BorderLayout.CENTER);
	}
}
public class BorderLaytDemo {
	public static void main(String[] args) {
		new BDemo();
	}
}

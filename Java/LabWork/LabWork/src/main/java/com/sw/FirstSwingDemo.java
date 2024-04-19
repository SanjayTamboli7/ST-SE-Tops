package com.sw;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class First {

	JFrame frame;
	JLabel l1;
	JTextField t1;
	JPasswordField p1;
	JButton b1;

	public First() {
		frame = new JFrame("First Demo");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("Enter Name : ");
		t1 = new JTextField(15);
		p1 = new JPasswordField(15);
		b1 = new JButton("Dispaly");
		frame.add(l1);
		frame.add(t1);
		frame.add(p1);
		frame.add(b1);
	}
}

public class FirstSwingDemo {
	public static void main(String[] args) {
		new First();

	}
}

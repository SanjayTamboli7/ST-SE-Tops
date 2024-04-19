package com.sw;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

class Second {
	JFrame frame;
	JCheckBox c1, c2, c3;
	JRadioButton r1, r2;
	ButtonGroup bg;

	public Second() {
		frame = new JFrame("Second Demo");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c1 = new JCheckBox("Cricket");
		c2 = new JCheckBox("Carrom");
		c3 = new JCheckBox("Chess");
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		frame.add(c1);
		frame.add(c2);
		frame.add(c3);
		frame.add(r1);
		frame.add(r2);
	}

}

public class SecondSwingDemo {
	public static void main(String[] args) {
		new Second();
	}
}

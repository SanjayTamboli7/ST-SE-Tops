package com.sw;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollBar;

class Fourth {
	JFrame frame;
	JScrollBar h, v;

	public Fourth() {
		frame = new JFrame("Fourth Demo");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		h = new JScrollBar(JScrollBar.HORIZONTAL, 1, 5, 0, 100);
		v = new JScrollBar(JScrollBar.VERTICAL, 1, 5, 0, 100);

		frame.add(h);
		frame.add(v);
	}
}

public class FourthSwingDemo {
	public static void main(String[] args) {
		new Fourth();
	}
}

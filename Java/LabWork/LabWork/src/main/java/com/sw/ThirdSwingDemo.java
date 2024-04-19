package com.sw;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

class Third {
	JFrame frame;
	JComboBox cb;
	JList list;
	JScrollPane pane;
	String[] city = { "Surat", "Navsari", "Nadiyad", "Baroda", "Vapi", "Rajkot", "Jamnagar", "Ahmedabad",
			"Surendranagar" };

	public Third() {
		frame = new JFrame("Third Demo");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cb = new JComboBox(city);
		list = new JList(city);
		list.setVisibleRowCount(4);
		pane = new JScrollPane(list);

		frame.add(cb);
		frame.add(pane);
	}
}

public class ThirdSwingDemo {
	public static void main(String[] args) {
		new Third();
	}
}

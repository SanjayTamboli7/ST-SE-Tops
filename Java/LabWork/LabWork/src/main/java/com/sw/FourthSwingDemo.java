package com.sw;

import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

class Fourth implements AdjustmentListener {
	JFrame frame;
	JScrollBar h, v;
	JLabel h1,v1;
	

	public Fourth() {
		frame = new JFrame("Fourth Demo");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		h1 = new JLabel("");
		v1 = new JLabel("");
		
		h = new JScrollBar(JScrollBar.HORIZONTAL, 1, 5, 0, 100);
		v = new JScrollBar(JScrollBar.VERTICAL, 1, 5, 0, 100);
		
		h.addAdjustmentListener(this);
		v.addAdjustmentListener(this);

		frame.add(h);
		frame.add(h1);
		frame.add(v);
		frame.add(v1);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if (e.getSource()==h) {
			h1.setText("Horizontal = " + h.getValue());
		}
		else {
			v1.setText("Vertical = " + v.getValue());
		}
	}
}

public class FourthSwingDemo {
	public static void main(String[] args) {
		new Fourth();
	}
}

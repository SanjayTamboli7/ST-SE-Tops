package com.sw;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class First implements ActionListener {

	JFrame frame;
	JLabel l1, ans;
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
		ans = new JLabel(" ");
//		p1 = new JPasswordField(15);
		b1 = new JButton("Dispaly");
		b1.addActionListener(this);
		frame.add(l1);
		frame.add(t1);
//		frame.add(p1);
		frame.add(b1);
		frame.add(ans);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource()==b1) {
//			ans.setText(t1.getText());
//		}

		if (e.getActionCommand().equals("Dispaly")) {
			ans.setText(t1.getText());
		}
	}
}

public class FirstSwingDemo {
	public static void main(String[] args) {
		new First();
	}
}

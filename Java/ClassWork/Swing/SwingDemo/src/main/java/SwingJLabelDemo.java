import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * This program demonstrates common programming practices for using JLabel
 * in Swing.
 *
 */
@SuppressWarnings("serial")
public class SwingJLabelDemo extends JFrame {
	
	public SwingJLabelDemo() {
		super("Demo program for JLabel");
		setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.anchor = GridBagConstraints.WEST;
		
		// a basic label
		JLabel label1 = new JLabel("This is a basic label");
		add(label1, constraints);
		
		// a label with only icon (icon file is in file system)
		JLabel label2 = new JLabel(new ImageIcon("images/attention.jpg"));
		constraints.gridy = 1;
		add(label2, constraints);

		// a label with only icon (icon file is in classpath or jar file)		
		String iconPath = "Images/Color.png";
//		Icon icon = new ImageIcon(getClass().getResource(iconPath));
		JLabel label3 = new JLabel(new ImageIcon("images/Color.jpg"));
		label3.setText("a label with icon in classpath");
		constraints.gridy = 2;
		add(label3, constraints);
		
		// a label with both text and icon
		JLabel label4 = new JLabel("A label with icon and text", 
				new ImageIcon("Images/attention.jpg"),
				SwingConstants.CENTER);
		label4.setIconTextGap(10);
		constraints.gridy = 3;
		add(label4, constraints);
		
		// customizes JLabel's appearance
		JLabel label5 = new JLabel("Enter first name:");
		label5.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
		label5.setOpaque(true);
		label5.setBackground(Color.WHITE);
		label5.setForeground(Color.BLUE);
		constraints.gridy = 4;
		add(label5, constraints);
		

		// using HTML code
		JLabel label6 = new JLabel();
		label6.setText("<html><font color=red size=4><b>WARNING!</b></html>");
		constraints.gridy = 5;
		add(label6, constraints);
		
		JLabel label7 = new JLabel("<html><i>This label has <br>two lines</i><html>");
		constraints.gridy = 6;
		add(label7, constraints);
		
		JLabel label8 = new JLabel("Enter e-mail address:");
		constraints.gridy = 7;
		constraints.gridwidth = 1;
		add(label8, constraints);
		
		JTextField textEmail = new JTextField(20);
		textEmail.setPreferredSize(new Dimension(100, 20));		
		constraints.gridx = 1;
		add(textEmail, constraints);
		
		// labeling the text field
		label8.setLabelFor(textEmail);
		label8.setDisplayedMnemonic('E');
		
		constraints.gridx = 1;
		constraints.gridy = 8;
		add(new JButton("Close"), constraints);
		
		setSize(400, 400);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingJLabelDemo().setVisible(true);
			}
		});
	}
}
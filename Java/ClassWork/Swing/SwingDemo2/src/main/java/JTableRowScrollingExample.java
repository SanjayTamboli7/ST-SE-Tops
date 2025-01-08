import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * This Swing program demonstrates how to scroll a table row to visible area
 * programmatically.
 * @author www.codejava.net
 *
 */
@SuppressWarnings("serial")
public class JTableRowScrollingExample extends JFrame implements ActionListener {

	private JTable table = new JTable();
	private JLabel label = new JLabel("Row number: ");
	private JTextField fieldRowNumber = new JTextField(5);
	private JButton buttonScroll = new JButton("Scroll to");
	
	public JTableRowScrollingExample() {
		super("JTable Row Scrolling Example");
		
		String columnNames[] = {"No#", "Name", "Age", "Job"};
		String[][] data = {
				{"1", "John", "30", "Developer"},
				{"2", "Jane", "31", "Designer"},
				{"3", "Peter", "28", "Programmer"},
				{"4", "Mary", "35", "Consultant"},
				{"5", "Kim", "27", "Developer"},
				{"6", "Geogre", "32", "Leader"},
				{"7", "Dash", "36", "Analyst"},
				{"8", "Tim", "25", "Designer"},
				{"9", "Ana", "29", "Developer"},
				{"10", "Tom", "41", "Manager"},
				{"11", "Sam", "40", "Consultant"},
				{"12", "Patrick", "38", "Manager"},
				{"13", "Jeremy", "24", "Programmer"},
				{"14", "David", "25", "Programmer"},
				{"15", "Steve", "26", "Designer"},
		};
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table.setModel(model);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(300, 150));
		
		add(scrollpane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(label);
		panel.add(fieldRowNumber);
		panel.add(buttonScroll);
		
		add(panel, BorderLayout.NORTH);
		
		buttonScroll.addActionListener(this);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JTableRowScrollingExample().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int rowNumber = Integer.parseInt(fieldRowNumber.getText());
		Rectangle cellRect = table.getCellRect(rowNumber, 0, false);
		System.out.println(cellRect);
		table.scrollRectToVisible(cellRect);
	}

}

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * This Swing program demonstrates how to set column with and row height
 * for a JTable component.
 * @author www.codejava.net
 *
 */

@SuppressWarnings("serial")
public class JTableColumnWidthRowHeightExample extends JFrame {
	private JTable table = new JTable();
	
	public JTableColumnWidthRowHeightExample() {
		super("JTable Column Width and Row Height Example");
		
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
		
		// sets row height		
		table.setRowHeight(30);
		table.setRowHeight(3, 60);

		
		// sets column width
		TableColumnModel columnModel = table.getColumnModel();
		
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(180);
		
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(480, 300));
		
		add(scrollpane, BorderLayout.CENTER);		
		
		// using utility method
		setJTableColumnsWidth(table, 480, 10, 30, 30, 30);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JTableColumnWidthRowHeightExample().setVisible(true);
			}
		});
	}
	
    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth, 
    		double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }
        
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }	
}

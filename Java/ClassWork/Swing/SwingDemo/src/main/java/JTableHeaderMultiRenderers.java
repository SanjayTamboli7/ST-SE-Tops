import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 * A Swing program demonstrates how to use multi custom renderers for
 * column headers of a JTable component. 
 * @author www.codejava.net
 *
 */
@SuppressWarnings("serial")
public class JTableHeaderMultiRenderers extends JFrame {

	private JTable table;
	
	public JTableHeaderMultiRenderers() {
		
		super("JTable Column Header Multi Custom Renderers");
		
		// constructs the table
		String[] columnNames = new String[] {"Position", "Team", "Won", "Drawn", "Lost", "Points"};
		String[][] rowData = new String[][] {
			{"1", "Manchester United", "28", "5", "5", "89"},	
			{"2", "Manchester City", "23", "9", "6", "78"},	
			{"3", "Chelsea", "22", "9", "7", "75"},	
			{"4", "Arsenal", "21", "10", "7", "73"},	
		};
				
		table = new JTable(rowData, columnNames);
		
		table.getTableHeader().setDefaultRenderer(new DefaultHeaderRenderer());
		table.getColumnModel().getColumn(2).setHeaderRenderer(new WonHeaderRenderer());
		table.getColumnModel().getColumn(3).setHeaderRenderer(new DrawnHeaderRenderer());
		table.getColumnModel().getColumn(4).setHeaderRenderer(new LostHeaderRenderer());
				
		add(new JScrollPane(table));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 150);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JTableHeaderMultiRenderers().setVisible(true);
			}
		});
	}	
}
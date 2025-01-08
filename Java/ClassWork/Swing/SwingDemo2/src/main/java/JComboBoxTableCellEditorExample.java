import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * This Swing program demonstrates the technique of customizing JTable's
 * cell editor using a JComboBox.
 * @author www.codejava.net
 *
 */
@SuppressWarnings("serial")
public class JComboBoxTableCellEditorExample extends JFrame {

	private JTable table = new JTable();
	private PersonTableModel tableModel;
	
	public JComboBoxTableCellEditorExample() {
		super("JComboBox Cell Editor for JTable Demo");
		
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(new Person("John", new Country("USA"), "Developer"));
		listPerson.add(new Person("Kim", new Country("South Korea"), "Designer"));
		listPerson.add(new Person("Peter", new Country("UK"), "Manager"));
		
		List<Country> listCountry = new ArrayList<>();
		listCountry.add(new Country("USA"));
		listCountry.add(new Country("UK"));
		listCountry.add(new Country("Japan"));
		listCountry.add(new Country("South Korea"));
		listCountry.add(new Country("Canada"));

		tableModel = new PersonTableModel(listPerson);
		table.setModel(tableModel);
		table.setDefaultRenderer(Country.class, new CountryCellRenderer());
		table.setDefaultEditor(Country.class, new CountryCellEditor(listCountry));
		table.setRowHeight(25);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(400, 200));
		
		add(scrollpane, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new JComboBoxTableCellEditorExample();
			}
		});
	}

}

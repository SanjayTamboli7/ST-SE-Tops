import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * A custom renderer for cells in the Country column.
 * @author www.codejava.net
 *
 */
@SuppressWarnings("serial")
public class CountryCellRenderer extends DefaultTableCellRenderer {
	
 	public Component getTableCellRendererComponent(JTable table, Object value, 
 			boolean isSelected, boolean hasFocus, int row, int column) {
 		if (value instanceof Country) {
 			Country country = (Country) value;
 			setText(country.getName());
 		}
 		
 		if (isSelected) {
 			setBackground(table.getSelectionBackground());
 		} else {
 			setBackground(table.getSelectionForeground());
 		}
 		
 		return this;
 	}
 	
}

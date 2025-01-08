import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * A simple renderer class for JTable component, but keep sort icons
 * by updating the default renderer instead of creating a new one.
 * @author www.codejava.net
 *
 */
public class DrawnHeaderRendererKeepSortIcon implements TableCellRenderer {
	
	private TableCellRenderer defaultRenderer;
	
	public DrawnHeaderRendererKeepSortIcon(TableCellRenderer defaultRenderer) {
		this.defaultRenderer = defaultRenderer;
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component comp = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		if (comp instanceof JLabel) {
			JLabel label = (JLabel) comp;
			label.setFont(new Font("Consolas", Font.BOLD, 14));
			label.setOpaque(true);
			label.setForeground(Color.BLACK);
			label.setBackground(Color.YELLOW);
			label.setBorder(BorderFactory.createEtchedBorder());
		}
		
		return comp;
	}

}
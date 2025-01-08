import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * A custom table model for the table of persons. 
 * @author www.codejava.net
 *
 */
@SuppressWarnings("serial")
public class PersonTableModel extends AbstractTableModel {
	private String[] columnNames = {"No.", "Name", "Country", "Job"};
	private List<Person> listPerson = new ArrayList<>();
	
	public PersonTableModel(List<Person> listPerson) {
		this.listPerson.addAll(listPerson);
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public Class getColumnClass(int column) {
    	return getValueAt(0, column).getClass();
    }

	@Override
	public int getRowCount() {
		return listPerson.size();
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Person person = listPerson.get(rowIndex);
		
		switch (columnIndex) {
		case 1:
				person.setName((String) value);
			break;
		case 2:
				person.setCountry((Country) value);
			break;
		case 3:
				person.setJob((String) value);
			break;
		}		
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object returnValue = null;
		Person person = listPerson.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
				returnValue = rowIndex + 1;
			break;
		case 1:
				returnValue = person.getName();
			break;
		case 2:
				returnValue = person.getCountry();
			break;
		case 3:
				returnValue = person.getJob();
			break;
		}
		
		return returnValue;
	}

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }	
}

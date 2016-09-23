import java.util.List;
import javax.swing.table.AbstractTableModel;

public class facultyTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940218617022640307L;

	/**
	 * 
	 */

	/**
	 * 
	 */

	String ColumnName[] = {"Name","Affiliated Department","Address","Mobile No.","E-mail Address"};
	
	List<Faculty> facList = null;
	
	facultyTableModel(List<Faculty> list){
		facList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return facList.size();
	}

	
	public Object getValueAt(int row, int column) {
		Faculty fac = facList.get(row);
		switch(column){
		case 0:
			return fac.facultyName;
		case 1:
			return fac.affiliatedDepartment;
		case 2:
			return fac.facultyAddress;
		case 3:
			return fac.mobile;
		case 4:
			return fac.email;
		case 5:
			return fac;
		default:
			return fac;
		}
	}
	@Override
	public Class<? extends Object> getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	@Override
	public String getColumnName(int col) {
		return ColumnName[col];
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}
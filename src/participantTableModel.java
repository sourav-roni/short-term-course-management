import java.util.List;
import javax.swing.table.AbstractTableModel;

public class participantTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1554518562750254278L;

	/**
	 * 
	 */

	/**
	 * 
	 */

	String ColumnName[] = {"Name","Organisation","Address","Mobile No.","E-mail Address"};
	
	List<Participant> partList = null;
	
	participantTableModel(List<Participant> list){
		partList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return partList.size();
	}

	
	public Object getValueAt(int row, int column) {
		Participant parti = partList.get(row);
		switch(column){
		case 0:
			return parti.participantName;
		case 1:
			return parti.participantOrganisation;
		case 2:
			return parti.participantAddress;
		case 3:
			return parti.participantMobile;
		case 4:
			return parti.participantEmail;
		case 5:
			return parti;
		default:
			return parti;
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
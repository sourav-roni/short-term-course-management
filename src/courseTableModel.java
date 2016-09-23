import java.util.List;
import javax.swing.table.AbstractTableModel;

public class courseTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3127450856150877769L;

	/**
	 * 
	 */

	/**
	 * 
	 */

	String ColumnName[] = {"Course Name","Course Fee","Course Start Date","Duration","Course Co-ordinator"};
	
	List<Course> courseList = null;
	
	courseTableModel(List<Course> list){
		courseList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return courseList.size();
	}

	
	public Object getValueAt(int row, int column) {
		Course reqCourse = courseList.get(row);
		switch(column){
		case 0:
			return reqCourse.courseName;
		case 1:
			return reqCourse.courseFee;
		case 2:
			return reqCourse.startDate;
		case 3:
			return reqCourse.courseDuration;
		case 4:
			if(reqCourse.courseCoordinatorStatus==1){
				return reqCourse.courseCoordinator.facultyName;
			}
			else{
				return "";
			}
		case 5:
			return reqCourse;
		default:
			return reqCourse;
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
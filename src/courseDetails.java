import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings("unused")
public class courseDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3400194797956749809L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseDetails frame = new courseDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public courseDetails(ArrayList<Course> courseArray,int index) {
		setTitle("Course Details for "+courseArray.get(index).courseName);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/icon.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 0, 729, 463);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Course Co-ordinator", null, scrollPane, null);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText("Name: "+courseArray.get(index).courseCoordinator.facultyName+"\n");
		textArea.append("Affiliated Department: "+courseArray.get(index).courseCoordinator.affiliatedDepartment+"\n");
		textArea.append("Address: "+courseArray.get(index).courseCoordinator.facultyAddress+"\n");
		textArea.append("Mobile No.: "+courseArray.get(index).courseCoordinator.mobile+"\n");
		textArea.append("E-mail ID: "+courseArray.get(index).courseCoordinator.email+"\n");
		facultyTableModel tableModel = new facultyTableModel(courseArray.get(index).facultylist);
		

		JTable partTable = new JTable();
		participantTableModel tableModel_1 = new participantTableModel(courseArray.get(index).participantlist);
		partTable.setModel(tableModel_1);
		JScrollPane scrollPane_2 = new JScrollPane(partTable);
		tabbedPane.addTab("Participant", null, scrollPane_2, null);
		

		JTable facultyTable = new JTable();
		facultyTable.setModel(tableModel);
		JScrollPane scrollPane_1 = new JScrollPane(facultyTable);
		tabbedPane.addTab("Faculty", null, scrollPane_1, null);
	}
}

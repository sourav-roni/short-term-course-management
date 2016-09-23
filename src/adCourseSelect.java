import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

@SuppressWarnings("unused")
public class adCourseSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1195193270345156925L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adCourseSelect frame = new adCourseSelect();
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
	public adCourseSelect(final ArrayList<Course> courseArray,final int param) {
		setTitle("Select Course");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
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
		
		final JTable courseTable = new JTable();
		courseTableModel tableModel = new courseTableModel(courseArray);
		courseTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(courseTable);
		scrollPane.setBounds(12, 0, 665, 406);
		contentPane.add(scrollPane);
		
		JButton btnSelect = new JButton("Delete/Alter");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int j,index;
				boolean selected = false;
				for(index=0;index<courseArray.size();index++){
					if(courseTable.isRowSelected(index)==true){
						selected  = true;
						break;
					}
				}
				if(selected==true){
					if(param==1){
						JFrame frame = new JFrame();
						String[] options = new String[2];
						options[0] = new String("Delete");
						options[1] = new String("Edit");
						j=JOptionPane.showOptionDialog(frame.getContentPane(),"What Do Want to Do?","Alter/Delete Courses", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
						if(j==0){
							courseArray.remove(courseTable.getSelectedRow());
							JOptionPane.showMessageDialog(null,"One Course Successfully Deleted.");
						}
						if(j==1){
							adCourse altCourse = new adCourse(courseArray,courseTable.getSelectedRow());
							altCourse.setVisible(true);
						}
					}
					if(param==2){
					    if(courseArray.get(courseTable.getSelectedRow()).courseCoordinatorStatus!=1){
					    	JOptionPane.showMessageDialog(null,"The Course does not have a Course Co-ordinator.");
					    }
					    else{
					    	JFrame frame = new JFrame();
							String[] options = new String[2];
							options[0] = new String("Delete");
							options[1] = new String("Edit");
							j=JOptionPane.showOptionDialog(frame.getContentPane(),"What Do Want to Do?","Edit Course Co-ordinator ", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
							if(j==0){
								courseArray.get(courseTable.getSelectedRow()).courseCoordinatorStatus=0;
								JOptionPane.showMessageDialog(null,"The Course Co-ordintor has been Successfully Deleted.");
							}
							if(j==1){
								adCoord adCoordinator = new adCoord(courseArray,courseTable.getSelectedRow());
								adCoordinator.setVisible(true);
							}
					    }
					}
					if(param==3){
						if(courseArray.get(courseTable.getSelectedRow()).facultylist.size()==0){
							JOptionPane.showMessageDialog(null,"The Course does not have any Faculty as Instructors.");
						}
						else{
							JOptionPane.showMessageDialog(null,"Please Select a Faculty Member.");
							facSelect altFac = new facSelect(courseArray,courseTable.getSelectedRow());
							altFac.setVisible(true);
						}
					}
					if(param==4){
						if(courseArray.get(courseTable.getSelectedRow()).participantlist.size()==0){
							JOptionPane.showMessageDialog(null,"The Course does not have any Participants yet.");
						}
						else{
							JOptionPane.showMessageDialog(null,"Please Select a Participant.");
							partSelect altPart = new partSelect(courseArray,courseTable.getSelectedRow());
							altPart.setVisible(true);
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please Select a Course.");
				}
				try
			      {
			         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(courseArray);
			         out.flush();
			         out.close();
			         fileOut.close();
			      }catch(IOException exe)
			      {
			          //exe.printStackTrace();
			      }
			}
		});
		btnSelect.setBounds(201, 418, 136, 25);
		contentPane.add(btnSelect);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(407, 418, 117, 25);
		contentPane.add(btnBack);

	}

}

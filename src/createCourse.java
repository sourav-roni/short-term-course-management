import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class createCourse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4556138833081169163L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createCourse frame = new createCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public boolean dateComparing(int userDate,ArrayList<Course> courseArray){
		boolean decision = true;
		int var1 = 0;
		int count = 0;
		while(var1<courseArray.size()){
			//System.out.println(var1);
			//System.out.println(	Coursemanagement.courseArray.get(var1).courseStartDate.get(Calendar.YEAR));
			//System.out.println(userDate);
			if(courseArray.get(var1).courseStartDate.get(Calendar.YEAR)==userDate){
				count++;
				//System.out.println(" " +count);
				if(count==10){
					return false;
				}
			}
			var1++;
		}
		return decision;
	}
	
	public boolean isStringLong(String s)
	{
	    try
	    {
	        Long.parseLong(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

	/**
	 * Create the frame.
	 */
	public createCourse(final ArrayList<Course> courseArray) {
		setTitle("Create Course");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of the Course");
		lblEnterTheName.setBounds(30, 23, 233, 15);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterCourseFees = new JLabel("Enter Course fees");
		lblEnterCourseFees.setBounds(30, 67, 233, 15);
		contentPane.add(lblEnterCourseFees);
		
		JLabel lblEnterTheCourse = new JLabel("Enter the Course Start Date");
		lblEnterTheCourse.setBounds(30, 105, 233, 24);
		contentPane.add(lblEnterTheCourse);
		
		JLabel lblEnterTheCourse_1 = new JLabel("Enter the Course Duration(within 2 weeks)");
		lblEnterTheCourse_1.setBounds(30, 153, 313, 15);
		contentPane.add(lblEnterTheCourse_1);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(370, 105, 185, 19);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblEnterTheName_1 = new JLabel("Enter the Name of the Course Co-ordinator ");
		lblEnterTheName_1.setBounds(30, 195, 311, 15);
		contentPane.add(lblEnterTheName_1);
		
		JLabel lblEnterThe = new JLabel("Enter the affiliated Department");
		lblEnterThe.setBounds(30, 236, 306, 15);
		contentPane.add(lblEnterThe);
		
		JLabel lblEnterTheAddress = new JLabel("Enter the Address of the Course Co-ordinator");
		lblEnterTheAddress.setBounds(30, 276, 328, 15);
		contentPane.add(lblEnterTheAddress);
		
		JLabel lblEnterMobileNo = new JLabel("Enter Mobile No. of Course Co-ordinator");
		lblEnterMobileNo.setBounds(30, 316, 341, 15);
		contentPane.add(lblEnterMobileNo);
		
		JLabel lblEnterEmailId = new JLabel("Enter Email ID of Course Co-ordinator");
		lblEnterEmailId.setBounds(30, 355, 328, 15);
		contentPane.add(lblEnterEmailId);
		
		final Course addCourse = new Course();
		
		JButton btnCreateCourse = new JButton("Create Course");
		btnCreateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCourse.courseName = textField.getText();
				addCourse.courseFee = textField_1.getText();
				SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
				try {
					addCourse.startDate = datef.format(dateChooser.getDate());
					addCourse.courseStartDate = dateChooser.getCalendar();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				addCourse.courseDuration =  textField_2.getText();
				addCourse.courseCoordinator.facultyName =  textField_3.getText();
				addCourse.courseCoordinator.affiliatedDepartment =  textField_4.getText();
				addCourse.courseCoordinator.facultyAddress =  textField_5.getText();
				addCourse.courseCoordinator.mobile =  textField_6.getText();
				addCourse.courseCoordinator.email =  textField_7.getText();
				boolean done = true;
				if(isStringLong(addCourse.courseCoordinator.mobile)==false){
					done = false;
					textField_6.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				boolean decided = dateComparing(addCourse.courseStartDate.get(Calendar.YEAR),courseArray);
				if(decided==false){
					done = false;
					JOptionPane.showMessageDialog(null, "Already 10 Courses have been created for the same Year. Select some other Year.");
					dateChooser.setBackground(Color.RED);
				}
				if(done==true){
					addCourse.courseCoordinatorStatus = 1;
					courseArray.add(addCourse);
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
					JOptionPane.showMessageDialog(null, "One Course has been successfully added!!");
					setVisible(false);
					displayAll afterAdd = new displayAll(courseArray);
					afterAdd.setVisible(true);
				}
		}});
		btnCreateCourse.setBounds(120, 408, 162, 25);
		contentPane.add(btnCreateCourse);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(392, 408, 143, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(370, 21, 243, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(370, 63, 243, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(370, 151, 243, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(370, 193, 243, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(370, 234, 243, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(370, 274, 243, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(370, 314, 243, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(370, 353, 243, 19);
		contentPane.add(textField_7);
	}
}

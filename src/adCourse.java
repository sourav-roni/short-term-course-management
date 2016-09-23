import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class adCourse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 485965479084293102L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adCourse frame = new adCourse();
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

	/**
	 * Create the frame.
	 */
	public adCourse(final ArrayList<Course> courseArray,final int index) {
		setTitle("Alter/Delete Course");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 401);
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
		
		JLabel lblEnterCourseName = new JLabel("Enter Course Name");
		lblEnterCourseName.setBounds(47, 56, 201, 15);
		contentPane.add(lblEnterCourseName);
		
		JLabel lblEnterCourseFees = new JLabel("Enter Course Fees");
		lblEnterCourseFees.setBounds(47, 100, 213, 15);
		contentPane.add(lblEnterCourseFees);
		
		JLabel lblEnterStartDate = new JLabel("Enter Start Date");
		lblEnterStartDate.setBounds(47, 147, 201, 15);
		contentPane.add(lblEnterStartDate);
		
		JLabel lblEnterDuration = new JLabel("Enter duration");
		lblEnterDuration.setBounds(47, 190, 213, 15);
		contentPane.add(lblEnterDuration);
		
		textField = new JTextField();
		textField.setBounds(300, 54, 224, 19);
		contentPane.add(textField);
		textField.setText(courseArray.get(index).courseName);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 98, 224, 19);
		textField_1.setText(courseArray.get(index).courseFee);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(300, 188, 224, 19);
		textField_2.setText(courseArray.get(index).courseDuration);
		contentPane.add(textField_2);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(301, 147, 100, 19);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setCalendar(courseArray.get(index).courseStartDate);
		contentPane.add(dateChooser);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseArray.get(index).courseName = textField.getText();
				courseArray.get(index).courseFee = textField_1.getText();
				SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
				try {
					courseArray.get(index).startDate = datef.format(dateChooser.getDate());
					courseArray.get(index).courseStartDate = dateChooser.getCalendar();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				courseArray.get(index).courseDuration =  textField_2.getText();
				boolean done = true;
				boolean decided = dateComparing(courseArray.get(index).courseStartDate.get(Calendar.YEAR),courseArray);
				if(decided==false){
					done = false;
					JOptionPane.showMessageDialog(null, "Already 10 Courses have been created for the same Year. Select some other Year.");
					dateChooser.setBackground(Color.RED);
				}
				if(done==true){
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
					JOptionPane.showMessageDialog(null, "The Course has been successfully modified!!");
					setVisible(false);
				}
			}
		});
		btnSaveChanges.setBounds(99, 297, 149, 25);
		contentPane.add(btnSaveChanges);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(353, 297, 141, 25);
		contentPane.add(btnBack);
	}
}

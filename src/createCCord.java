import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class createCCord extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4813080009538720198L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createCCord frame = new createCCord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
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
	public createCCord(final ArrayList<Course> courseArray,final int index) {
		setTitle("Create Co-ordinator");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 375);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of the Course Co-ordinator");
		lblEnterTheName.setBounds(36, 29, 324, 15);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheAffiliated = new JLabel("Enter the affiliated Department");
		lblEnterTheAffiliated.setBounds(36, 72, 311, 15);
		contentPane.add(lblEnterTheAffiliated);
		
		JLabel lblEnterTheAddress = new JLabel("Enter  the Address ");
		lblEnterTheAddress.setBounds(36, 122, 324, 15);
		contentPane.add(lblEnterTheAddress);
		
		JLabel lblEnterTheMobile = new JLabel("Enter the Mobile Number ");
		lblEnterTheMobile.setBounds(36, 172, 349, 15);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmail = new JLabel("Enter the E-mail ID ");
		lblEnterTheEmail.setBounds(36, 217, 251, 15);
		contentPane.add(lblEnterTheEmail);
		
		final Faculty coord = new Faculty();
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseArray.get(index).courseCoordinator.facultyName = textField.getText();
				courseArray.get(index).courseCoordinator.affiliatedDepartment = textField_1.getText();
				courseArray.get(index).courseCoordinator.facultyAddress = textField_2.getText();
				courseArray.get(index).courseCoordinator.mobile = textField_3.getText();
				courseArray.get(index).courseCoordinator.email = textField_4.getText();
				boolean done = true;
				if(isStringLong(courseArray.get(index).courseCoordinator.mobile )==false){
					done = false;
					textField_3.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				if(done==true){
					courseArray.get(index).courseCoordinatorStatus = 1;
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
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Course Co-ordinator Successfully Added!!");
				}
			}
		});
		btnNewButton.setBounds(125, 295, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(410, 295, 117, 25);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(389, 24, 242, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(389, 70, 242, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(389, 120, 242, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(389, 162, 242, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(389, 207, 242, 25);
		contentPane.add(textField_4);
	}
}

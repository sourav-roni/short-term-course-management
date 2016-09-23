import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class facAdd extends JFrame {

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
					facAdd frame = new facAdd();
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
	public facAdd(final ArrayList<Course> courseArray,final int index) {
		setTitle("Add New Faculty");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 398);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the name of the Faculty");
		lblEnterTheName.setBounds(52, 36, 230, 15);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheAffiliated = new JLabel("Enter the affiliated Department");
		lblEnterTheAffiliated.setBounds(52, 79, 263, 15);
		contentPane.add(lblEnterTheAffiliated);
		
		JLabel lblEnterTheAddress = new JLabel("Enter the Address");
		lblEnterTheAddress.setBounds(52, 124, 230, 15);
		contentPane.add(lblEnterTheAddress);
		
		JLabel lblEnterTheMobile = new JLabel("Enter the Mobile Number");
		lblEnterTheMobile.setBounds(52, 166, 209, 15);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmail = new JLabel("Enter the E-mail ID");
		lblEnterTheEmail.setBounds(52, 212, 230, 15);
		contentPane.add(lblEnterTheEmail);
		
		final Faculty newFac = new Faculty();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newFac.facultyName = textField.getText();
				newFac.affiliatedDepartment = textField_1.getText();
				newFac.facultyAddress = textField_2.getText();
				newFac.mobile = textField_3.getText();
				newFac.email = textField_4.getText();
				boolean done = true;
				if(isStringLong(newFac.mobile)==false){
					done = false;
					textField_3.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				if(done==true){
					courseArray.get(index).facultylist.add(newFac);
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
					JOptionPane.showMessageDialog(null, "One Faculty has been successfully added!!");
					setVisible(false);
				}
			}
		});
		btnAdd.setBounds(130, 275, 117, 25);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(388, 275, 117, 25);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(353, 34, 271, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(353, 77, 271, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(353, 122, 271, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(353, 164, 271, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(353, 210, 271, 19);
		contentPane.add(textField_4);
	}

}

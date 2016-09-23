import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({ "serial", "unused" })
public class adFac extends JFrame {

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
	public adFac(final ArrayList<Course> courseArray,final int index,final int ind) {
		setTitle("Alter Details of Faculty");
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
		
		textField = new JTextField();
		textField.setBounds(353, 34, 271, 19);
		textField.setText(courseArray.get(index).facultylist.get(ind).facultyName);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(353, 77, 271, 19);
		textField_1.setText(courseArray.get(index).facultylist.get(ind).affiliatedDepartment);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(353, 122, 271, 19);
		textField_2.setText(courseArray.get(index).facultylist.get(ind).facultyAddress);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(353, 164, 271, 19);
		textField_3.setText(courseArray.get(index).facultylist.get(ind).mobile);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(353, 210, 271, 19);
		textField_4.setText(courseArray.get(index).facultylist.get(ind).email);
		contentPane.add(textField_4);
		
		JButton btnAdd = new JButton("Save Changes");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseArray.get(index).facultylist.get(ind).facultyName = textField.getText();
				courseArray.get(index).facultylist.get(ind).affiliatedDepartment = textField_1.getText();
				courseArray.get(index).facultylist.get(ind).facultyAddress = textField_2.getText();
				courseArray.get(index).facultylist.get(ind).mobile = textField_3.getText();
				courseArray.get(index).facultylist.get(ind).email = textField_4.getText();
				boolean done = true;
				if(isStringLong(courseArray.get(index).facultylist.get(ind).mobile)==false){
					done = false;
					textField_3.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
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
					JOptionPane.showMessageDialog(null, "Changes to Faculty has been successfully saved!!");
					setVisible(false);
				}
			}
		});
		btnAdd.setBounds(130, 275, 152, 25);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(388, 275, 145, 25);
		contentPane.add(btnBack);
	}

}

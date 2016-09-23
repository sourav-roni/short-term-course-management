import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class adPart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4950728977374342721L;
	/**
	 * 
	 */
	
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
					partAdd frame = new partAdd();
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
	public adPart(final ArrayList<Course> courseArray,final int index,final int ind) {
		setTitle("Alter Participant");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 379);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of the Participant");
		lblEnterTheName.setBounds(38, 38, 247, 15);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheOrganisation = new JLabel("Enter the Organisation");
		lblEnterTheOrganisation.setBounds(38, 79, 236, 15);
		contentPane.add(lblEnterTheOrganisation);
		
		JLabel lblEnterTheAddress = new JLabel("Enter the Address");
		lblEnterTheAddress.setBounds(38, 121, 247, 15);
		contentPane.add(lblEnterTheAddress);
		
		JLabel lblEnterTheMobile = new JLabel("Enter the Mobile Number");
		lblEnterTheMobile.setBounds(38, 162, 236, 15);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmailid = new JLabel("Enter the Email-ID");
		lblEnterTheEmailid.setBounds(41, 202, 215, 15);
		contentPane.add(lblEnterTheEmailid);
		
		textField = new JTextField();
		textField.setBounds(351, 38, 270, 25);
		textField.setText(courseArray.get(index).participantlist.get(ind).participantName);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(351, 77, 270, 25);
		textField_1.setText(courseArray.get(index).participantlist.get(ind).participantOrganisation);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(351, 116, 270, 25);
		textField_2.setText(courseArray.get(index).participantlist.get(ind).participantAddress);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(351, 157, 270, 25);
		textField_3.setText(courseArray.get(index).participantlist.get(ind).participantMobile);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(351, 197, 270, 25);
		textField_4.setText(courseArray.get(index).participantlist.get(ind).participantEmail);
		contentPane.add(textField_4);
		
		JButton btnAdd = new JButton("Save Changes");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseArray.get(index).participantlist.get(ind).participantName = textField.getText();
				courseArray.get(index).participantlist.get(ind).participantOrganisation =textField_1.getText();
				courseArray.get(index).participantlist.get(ind).participantAddress = textField_2.getText();
				courseArray.get(index).participantlist.get(ind).participantMobile = textField_3.getText();
				courseArray.get(index).participantlist.get(ind).participantEmail = textField_4.getText();
				boolean done = true;
				if(isStringLong(courseArray.get(index).participantlist.get(ind).participantMobile)==false){
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
					JOptionPane.showMessageDialog(null, "Changes to Participant has been successfully saved!!");
					setVisible(false);
				}
			}
		});
		btnAdd.setBounds(111, 278, 145, 25);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(391, 278, 138, 25);
		contentPane.add(btnBack);
	}

}

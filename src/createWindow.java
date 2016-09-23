import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class createWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -850232125271694314L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createWindow frame = new createWindow();
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
	public createWindow(final ArrayList<Course> courseArray) {
		setTitle("Create");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 461);
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
		
		JLabel lblPleaseSelectYour = new JLabel("Please Select Your Choice");
		lblPleaseSelectYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectYour.setBounds(195, 22, 230, 15);
		contentPane.add(lblPleaseSelectYour);
		
		JButton btnCreateANew = new JButton("Create a New Course and Display All Courses ");
		btnCreateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createCourse newCourse = new createCourse(courseArray);
				newCourse.setVisible(true);
			}
		});
		btnCreateANew.setBounds(120, 68, 364, 25);
		contentPane.add(btnCreateANew);
		
		JButton btnNewButton = new JButton("Create a New Course Co-ordinator");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coordCreateSelect newcoord = new coordCreateSelect(courseArray);
				newcoord.setVisible(true);
			}
		});
		btnNewButton.setBounds(120, 129, 364, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create new Faculty for a Course");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				facCreateSelect newFaci = new facCreateSelect(courseArray);
				newFaci.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(120, 194, 364, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnCreateNewParticipant = new JButton("Create New Participant for a Course");
		btnCreateNewParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partiCreateSelect newParti = new partiCreateSelect(courseArray);
				newParti.setVisible(true);
			}
		});
		btnCreateNewParticipant.setBounds(120, 255, 364, 25);
		contentPane.add(btnCreateNewParticipant);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(236, 338, 117, 25);
		contentPane.add(btnBack);
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image));
	}

}

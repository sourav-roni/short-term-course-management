import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class stcmMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3589808852350459269L;
	private JPanel contentPane;
	public static ArrayList<Course> courseArray = new ArrayList<Course>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unchecked")
			public void run() {
				try {
					stcmMainWindow frame = new stcmMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try
			      {
			         FileInputStream fileIn = new FileInputStream("shorttermcoursemanagement");
			         ObjectInputStream input = null;
					try {
						input = new ObjectInputStream(fileIn);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			         try {
						courseArray = (ArrayList<Course>) input.readObject();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			         try {
						input.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
			         try {
						fileIn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			      }catch(FileNotFoundException a)
			      {
			         //System.out.println("OOPs!! File Not Found");
			      }catch(ClassNotFoundException c)
			      {
			         //System.out.println("ArrayList<Course> class not found");
			         //c.printStackTrace();
			         return;
			      }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public stcmMainWindow() {
		setTitle("Short Term Course Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 493);
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
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(255, 26, 91, 15);
		contentPane.add(lblWelcome);
		
		JLabel lblShortTermCourse = new JLabel("Short Term Course Management");
		lblShortTermCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblShortTermCourse.setBounds(179, 55, 257, 26);
		contentPane.add(lblShortTermCourse);
		
		JLabel lblIitKharagpur = new JLabel("IIT Kharagpur");
		lblIitKharagpur.setHorizontalAlignment(SwingConstants.CENTER);
		lblIitKharagpur.setBounds(212, 93, 187, 15);
		contentPane.add(lblIitKharagpur);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createWindow newCreate = new createWindow(courseArray);
				newCreate.setVisible(true);
			}
		});
		btnCreate.setBounds(179, 157, 278, 25);
		contentPane.add(btnCreate);
		
		JButton btnAlterDelete = new JButton("Alter / Delete");
		btnAlterDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteWindow newAlter = new deleteWindow(courseArray);
				newAlter.setVisible(true);
			}
		});
		btnAlterDelete.setBounds(179, 207, 278, 25);
		contentPane.add(btnAlterDelete);
		
		JButton btnDisplayCoursesIn = new JButton("Display courses in past Five Years");
		btnDisplayCoursesIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastFive newLast = new lastFive(courseArray);
				newLast.setVisible(true);
			}
		});
		btnDisplayCoursesIn.setBounds(179, 261, 278, 25);
		contentPane.add(btnDisplayCoursesIn);
		
		JButton btnDisplayAllCourses = new JButton("Display All Courses Created so far");
		btnDisplayAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayAll allCourses = new displayAll(courseArray);
				allCourses.setVisible(true);
			}
		});
		btnDisplayAllCourses.setBounds(179, 318, 278, 25);
		contentPane.add(btnDisplayAllCourses);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(179, 377, 278, 25);
		try {
			image = ImageIO.read(getClass().getResource("/exit.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnExit.setIcon(new ImageIcon( image));
		contentPane.add(btnExit);
	}
}

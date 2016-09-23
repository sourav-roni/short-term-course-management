import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class deleteWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3795296829498419470L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteWindow frame = new deleteWindow();
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
	public deleteWindow(final ArrayList<Course> courseArray) {
		setTitle("Alter/Delete");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 411);
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
		
		JButton btnAlter = new JButton("Alter/Delete Details of Courses");
		btnAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adCourseSelect alter = new adCourseSelect(courseArray,1);
				alter.setVisible(true);
			}
		});
		btnAlter.setBounds(131, 39, 352, 25);
		contentPane.add(btnAlter);
		
		JButton btnAlterdeleteDetailsOf = new JButton("Alter/Delete Details of Course Co-ordinators");
		btnAlterdeleteDetailsOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adCourseSelect alter = new adCourseSelect(courseArray,2);
				alter.setVisible(true);
			}
		});
		btnAlterdeleteDetailsOf.setBounds(131, 103, 352, 25);
		contentPane.add(btnAlterdeleteDetailsOf);
		
		JButton btnNewButton = new JButton("Alter/Delete Details of Faculty Members");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adCourseSelect alter = new adCourseSelect(courseArray,3);
				alter.setVisible(true);
			}
		});
		btnNewButton.setBounds(131, 169, 352, 25);
		contentPane.add(btnNewButton);
		
		JButton btnAlterdeleteDetailsOf_1 = new JButton("Alter/Delete Details of Participants");
		btnAlterdeleteDetailsOf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adCourseSelect alter = new adCourseSelect(courseArray,4);
				alter.setVisible(true);
			}
		});
		btnAlterdeleteDetailsOf_1.setBounds(131, 234, 352, 25);
		contentPane.add(btnAlterdeleteDetailsOf_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(253, 307, 117, 25);
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image));
		contentPane.add(btnBack);
	}

}

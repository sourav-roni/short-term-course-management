import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("unused")
public class facCreateSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2154618568228454638L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facCreateSelect frame = new facCreateSelect();
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
	public facCreateSelect(final ArrayList<Course> courseArray) {
		setTitle("Select Course");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 495);
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
		
		final JTable courseTable = new JTable();
		courseTableModel tableModel = new courseTableModel(courseArray);
		courseTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(courseTable);
		scrollPane.setBounds(12, 0, 665, 406);
		contentPane.add(scrollPane);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(courseArray.get(courseTable.getSelectedRow()).facultylist.size()<5){
					facAdd newFac = new facAdd(courseArray,courseTable.getSelectedRow());
					newFac.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null,"The Course Already has 5 Instructors.");
				}
			}
		});
		btnSelect.setBounds(201, 418, 117, 25);
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

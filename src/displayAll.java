import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("unused")
public class displayAll extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329073683128968213L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayAll frame = new displayAll();
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
	public displayAll(final ArrayList<Course> courseArray) {
		setTitle("Display Courses");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 520);
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
		scrollPane.setBounds(12, 0, 658, 439);
		contentPane.add(scrollPane);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseDetails detailit = new courseDetails(courseArray,courseTable.getSelectedRow());
				detailit.setVisible(true);
			}
		});
		btnGetDetails.setBounds(159, 451, 117, 25);
		contentPane.add(btnGetDetails);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(424, 451, 117, 25);
		contentPane.add(btnBack);
	}
}

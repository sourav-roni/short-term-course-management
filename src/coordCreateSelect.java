import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

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
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("unused")
public class coordCreateSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2254556503040772390L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coordCreateSelect frame = new coordCreateSelect();
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
	public coordCreateSelect(final ArrayList<Course> courseArray) {
		setTitle("Select Course");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 510);
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
		
		final JTable courseTable = new JTable();
		courseTableModel tableModel = new courseTableModel(courseArray);
		courseTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(courseTable);
		scrollPane.setBounds(12, 12, 670, 425);
		contentPane.add(scrollPane);
		
		JButton btnAddCoordinator = new JButton("Add Co-ordinator");
		btnAddCoordinator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(courseArray.get(courseTable.getSelectedRow()).courseCoordinatorStatus==1){
					JOptionPane.showMessageDialog(null,"The Course Already has a Course Co-ordinator.");
				}
				else{
					createCCord addCord = new createCCord(courseArray,courseTable.getSelectedRow());
					addCord.setVisible(true);
				}
			}
		});
		btnAddCoordinator.setBounds(92, 445, 155, 25);
		contentPane.add(btnAddCoordinator);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(403, 445, 155, 25);
		contentPane.add(btnBack);
	}
}

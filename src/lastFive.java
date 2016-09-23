import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("unused")
public class lastFive extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1630636821106467125L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lastFive frame = new lastFive();
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
	public lastFive(final ArrayList<Course> courseArray) {
		setTitle("Display Courses Created During Last Five Years");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 222);
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
		
		JLabel lblPleaseEnterA = new JLabel("Please Enter a Date");
		lblPleaseEnterA.setBounds(41, 12, 175, 15);
		contentPane.add(lblPleaseEnterA);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(247, 8, 165, 19);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		final ArrayList<Course> newCourseArray = new ArrayList<Course>();
		courseTableModel tableModel = new courseTableModel(newCourseArray);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i,size=newCourseArray.size();
				System.out.println("old:"+newCourseArray.size());
				for(i=size-1;i>=0;i--){
					System.out.println("i="+i);
					newCourseArray.remove(i);
				}
				SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/yyyy");
				Calendar calendar = dateChooser.getCalendar();
				Calendar calendarPast = (Calendar) calendar.clone();
				calendarPast.add(Calendar.YEAR, -5);
				int m;
				for(m=0;m<courseArray.size();m++){
					if(courseArray.get(m).courseStartDate.getTime().after(calendarPast.getTime())&&courseArray.get(m).courseStartDate.getTime().before(calendar.getTime())){
						newCourseArray.add(courseArray.get(m));
					}
				}
				System.out.println("new:"+newCourseArray.size());
				displayAll selected = new displayAll(newCourseArray);
				selected.setVisible(true);
				}
		});
		btnGo.setBounds(154, 82, 117, 25);
		contentPane.add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(379, 82, 117, 25);
		contentPane.add(btnBack);
	}
}

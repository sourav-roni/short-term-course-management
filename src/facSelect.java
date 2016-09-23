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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("unused")
public class facSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6967636527536281554L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					facSelect frame = new facSelect();
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
	public facSelect(final ArrayList<Course> courseArray,final int index) {
		setTitle("Select Faculty");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 495);
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
		
		final JTable facTable = new JTable();
		facultyTableModel tableModel = new facultyTableModel(courseArray.get(index).facultylist);
		facTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(facTable);
		scrollPane.setBounds(12, 12, 709, 393);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Delete/Alter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ind,j;
				boolean select = false;
				for(ind=0;ind<courseArray.get(index).facultylist.size();ind++){
					if(facTable.isRowSelected(ind)==true){
						select = true;
						break;
					}
				}
				if(select==true){
					JFrame frame = new JFrame();
					String[] options = new String[2];
					options[0] = new String("Delete");
					options[1] = new String("Edit");
					j=JOptionPane.showOptionDialog(frame.getContentPane(),"What Do Want to Do?","Alter/Delete Faculty ", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
					if(j==0){
						courseArray.get(index).facultylist.remove(ind);
						JOptionPane.showMessageDialog(null,"Faculty Successfully Deleted.");
					}
					if(j==1){
						adFac editFac = new adFac(courseArray,index,ind);
						editFac.setVisible(true);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please Select a Faculty.");
				}
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
			}
		});
		btnNewButton.setBounds(114, 417, 153, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(367, 417, 146, 25);
		contentPane.add(btnNewButton_1);
	}

}

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class partSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6257467810315351282L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					partSelect frame = new partSelect();
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
	public partSelect(final ArrayList<Course> courseArray,final int index) {
		setTitle("Select Participant");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 508);
		contentPane = new JPanel();
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
		
		final JTable partTable = new JTable();
		participantTableModel tableModel = new participantTableModel(courseArray.get(index).participantlist);
		partTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(partTable);
		scrollPane.setBounds(12, 12, 628, 407);
		contentPane.add(scrollPane);
		
		JButton btnAlterdelete = new JButton("Alter/Delete");
		btnAlterdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ind,j;
				boolean select = false;
				for(ind=0;ind<courseArray.get(index).participantlist.size();ind++){
					if(partTable.isRowSelected(ind)==true){
						select = true;
						break;
					}
				}
				if(select==true){
					JFrame frame = new JFrame();
					String[] options = new String[2];
					options[0] = new String("Delete");
					options[1] = new String("Edit");
					j=JOptionPane.showOptionDialog(frame.getContentPane(),"What Do Want to Do?","Alter/Delete Participant ", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
					if(j==0){
						courseArray.get(index).participantlist.remove(ind);
						JOptionPane.showMessageDialog(null,"Participant Successfully Deleted.");
					}
					if(j==1){
						adPart editPart = new adPart(courseArray,index,ind);
						editPart.setVisible(true);
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please Select a Partcipant.");
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
		btnAlterdelete.setBounds(131, 443, 149, 25);
		contentPane.add(btnAlterdelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(384, 443, 140, 25);
		contentPane.add(btnBack);
	}

}

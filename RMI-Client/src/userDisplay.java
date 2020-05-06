

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class userDisplay {

	private JFrame frame;
	private static JTable table;
	static ArrayList<fireAlarm> list  = new 
			ArrayList<fireAlarm>();
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userDisplay window = new userDisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	static void updateArrayList(ArrayList<fireAlarm> mlist) {
		list=mlist;
		notifyDataSetChanged();
	}

	static void notifyDataSetChanged() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.getDataVector().removeAllElements();
	    
	    Object rowData[] = new Object[4];
	    
	    for(int i = 0; i < list.size(); i++)
	    {
	    	model.addColumn("ID"); 
	    	model.addColumn("fLOOR nO"); 
	    	
	        model.addRow(new Object[]{list.get(i).toString()});
	    }


	// add header of the table
	String header[] = new String[] { "Sensors" };

	// add header in table model     
	model.setColumnIdentifiers(header);
	  //set model into the table object
	table.setModel(model);
	}
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public userDisplay() throws Exception {
		initialize();
		RMI_Client rmc=new RMI_Client();
		list=rmc.readAll();
		notifyDataSetChanged();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				login b3 = new login();
				b3.main(null);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(189, 183, 107));
		btnNewButton.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 87, 386, 153);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

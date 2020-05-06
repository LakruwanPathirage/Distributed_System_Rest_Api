

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.sun.tools.javac.code.Attribute.Array;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Frame1 extends JFrame{
	public Frame1() {
	}

	

	private static JFrame frame;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTable table;
	static ArrayList<fireAlarm> list  = new 
			ArrayList<fireAlarm>();
	
	
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
	
	public static void main(String[] args) throws Exception {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame1 window = new Frame1();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		initialize();
		
		RMI_Client rmc=new RMI_Client();
		list=rmc.readAll();
		notifyDataSetChanged();
	}
	

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 706, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
			
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				try {
					RMI_Client client=new RMI_Client();
//					DefaultTableModel model = (DefaultTableModel)table.getModel();
//					model.addRow(new Object [] {Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText()),});
					client.add((textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()));
				
					JOptionPane .showMessageDialog(frame, "Data added");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					
					list=client.readAll();
					notifyDataSetChanged();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
//		btnNewButton.setBounds(35, 41, 130, 36);
//		frame.getContentPane().add(btnNewButton);
//		
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(52, 88, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		
				
//				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3307/firealarm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
//					
//					
//				
//
//					String query1 = "Update sensors set ID = '"+textField.getText()+"', floorNo = '"+textField_1.getText()+"', roomNo = '"+textField_2.getText()+"', smokeLvl = '"+textField_3.getText()+"', CO2Lvl = '"+textField_4.getText()+"' where ID = '"+textField.getText()+"' ";
//					PreparedStatement stm = con2.prepareStatement(query1);
//					
//
//							stm.execute();
//							JOptionPane.showMessageDialog(null,"Data Updated");
//							Frame1 h1 = new Frame1();
//							h1.setVisible(true);
//					
//
//						stm.close();
//						
//					
//				}catch(Exception e1) {
//					
//					System.out.println(e1);
//					
//				}
				
		
//		btnUpdate.setBounds(564, 451, 122, 35);
//		frame.getContentPane().add(btnUpdate);
		
	
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
	
			
			public void actionPerformed(ActionEvent e) {
//				
				try {
					RMI_Client client=new RMI_Client();
					client.delete(textField.getText());
					
					
//					System.out.println("selected :"+(textField.getText()));
//					
//					textField.getText();
//					
//					System.out.println(textField.getText());
					
//					int a = table.getSelectedRow();
//					((DefaultTableModel)table.getModel()).removeRow(a);
		        	
					for( int a = table.getSelectedRow() - 1; a >= 0; a-- )
					{
						table.remove(a);
					}
					RMI_Client rmc=new RMI_Client();
					list=rmc.readAll();
					notifyDataSetChanged();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
//				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3307/firealarm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
//				
//					
//				
//
//					String query2 = "delete from sensors where ID = '"+textField.getText()+"' ";
//					PreparedStatement stm = con3.prepareStatement(query2);
//					
//
//							stm.execute();
//							JOptionPane.showMessageDialog(null,"Data Deleted");
//							Frame1 h3 = new Frame1();
//							h3.setVisible(true);
//					
//
//						stm.close();
//						
//					
//				}catch(Exception e1) {
//					
//					System.out.println(e1);
//					
//				}
				
			}
			
		});
		
		
//		btnDeleteSensor.setBounds(698, 450, 122, 36);
//		contentPane.add(btnDeleteSensor);
		
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(342, 88, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblFloorNo = new JLabel("Floor No");
		lblFloorNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFloorNo.setForeground(new Color(255, 255, 255));
		lblFloorNo.setBounds(12, 189, 87, 16);
		frame.getContentPane().add(lblFloorNo);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRoomNo.setForeground(new Color(255, 255, 255));
		lblRoomNo.setBounds(12, 229, 87, 16);
		frame.getContentPane().add(lblRoomNo);
		
		JLabel lblNewLabel_1 = new JLabel("Level of Smoke");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(12, 279, 116, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Level of CO2");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(12, 327, 97, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(139, 138, 80, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 187, 80, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 227, 80, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(140, 277, 80, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(138, 325, 80, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnBack = new JButton("Logout");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				login b2 = new login();
				b2.main(null);
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(189, 183, 107));
		btnBack.setBounds(29, 39, 97, 25);
		frame.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 141, 434, 206);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
//					DefaultTableModel model = (DefaultTableModel)table.getModel();
//					model.addRow(new Object [] {Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText()),});
					RMI_Client client=new RMI_Client();
					fireAlarm fa1=new fireAlarm((textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()));
					client.update(fa1);
					JOptionPane .showMessageDialog(frame, "Updated");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					
					RMI_Client rmc=new RMI_Client();
					list=rmc.readAll();
					notifyDataSetChanged();
					
				} catch (Exception ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(171, 88, 97, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent lse) {
		        if (!lse.getValueIsAdjusting()) {
		            System.out.println("Selection Changed");
		            fireAlarm alarm = list.get(table.getSelectedRow());
		            textField.setText(alarm.id);
		            textField_1.setText(String.valueOf(alarm.floor));
		            textField_2.setText(String.valueOf(alarm.roomNumber));
		            textField_3.setText(String.valueOf(alarm.smokelevel));
		            textField_4.setText(String.valueOf(alarm.co2level));
		        }
		    }
		});
	}


}

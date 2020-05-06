

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class loginAdmin {

	private JFrame frame;
	private JPasswordField passwordField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginAdmin window = new loginAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(186, 36, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(43, 88, 75, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(43, 142, 75, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(143, 88, 118, 22);
		frame.getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 139, 118, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uName = textPane.getText();
				String pwd = passwordField.getText();
				
				if(uName.equals("admin") && pwd.equals("admin")) {
					
			
					frame.dispose();
					Frame1 n;
					try {
						n = new Frame1();
						n.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					
					JOptionPane .showMessageDialog(frame, "Invalid User Name Or Password");
					textPane.setText(null);
					passwordField.setText(null);
				}
			}
		});
		btnNewButton.setBounds(164, 201, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				login b = new login();
				b.main(null);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}

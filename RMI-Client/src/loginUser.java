

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginUser {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUser window = new loginUser();
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
	public loginUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("User");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(183, 28, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("User Name : ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(38, 89, 97, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(38, 145, 79, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(158, 89, 123, 22);
		frame.getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 139, 123, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uName = textPane.getText();
				String pwd = passwordField.getText();
				
				if(uName.equals("user") && pwd.equals("user")) {
					
					
					frame.dispose();
					userDisplay n;
					try {
						n = new userDisplay();
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
		btnNewButton.setBounds(171, 189, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login b1 = new login();
				b1.main(null);
			}
		});
		btnNewButton_1.setBackground(new Color(189, 183, 107));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(12, 13, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}

	
}

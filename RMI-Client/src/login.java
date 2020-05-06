

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 206, 209));
		frame.setBounds(100, 100, 513, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("User");
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				loginUser n = new loginUser();
				n.main(null);
			}
		});
		btnNewButton.setBounds(114, 127, 97, 25);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Admin");
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
				loginAdmin n1 = new loginAdmin();
				n1.main(null);
			}
		});
		btnNewButton_1.setBounds(286, 127, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
	}
}

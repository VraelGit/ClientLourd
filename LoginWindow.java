package PPE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogin;
	private JLabel lblPass;
	private JTextField textFieldLogin;
	private JTextField textFieldPass;
	private String login,pass;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		MySQLCon sqlc1 = new MySQLCon();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 69, 14);
		contentPane.add(lblLogin);

		lblPass = new JLabel("Password");
		lblPass.setBounds(10, 36, 69, 14);
		contentPane.add(lblPass);

		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 95, 270, 14);
		contentPane.add(lblMsg);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(89, 8, 191, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldPass = new JTextField();
		textFieldPass.setBounds(89, 33, 191, 20);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);

		JButton btnConn = new JButton("Connexion");
		btnConn.setBounds(10, 64, 270, 20);
		contentPane.add(btnConn);

		btnConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!textFieldLogin.getText().isEmpty() || !textFieldPass.getText().isEmpty()){
					login = textFieldLogin.getText();
					pass = textFieldPass.getText();

					if(sqlc1.login(login, pass) == 1){
						dispose();
						MainMenu main = new MainMenu();
						main.newF();
					}else {
						lblMsg.setText("Mauvais e-mail / mdp");
					}
				}else {
					lblMsg.setText("Saissez vos identifiants");
				}
			}
		});

	}
}

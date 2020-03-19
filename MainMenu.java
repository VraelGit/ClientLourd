package PPE;

import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAutopower = new JLabel("Application d'administration");
		lblAutopower.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblAutopower.setBounds(28, 11, 373, 49);
		frame.getContentPane().add(lblAutopower);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnUn = new JMenu("Menu");
		menuBar.add(mnUn);

		JMenuItem mntmUser = new JMenuItem("Act / Desac Utilisateurs");
		mntmUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAccount frame = new UserAccount();
				frame.setVisible(true);
			}

		});
		
		JMenuItem mntmAnnonce = new JMenuItem("Act / Desac Annonce");
		mntmAnnonce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Annonce frame = new Annonce();
				frame.setVisible(true);
			}
		});
		
		mnUn.add(mntmUser);	
		mnUn.add(mntmAnnonce);
	}

	public void newF() {
		// Pour créer nouvelle frame de MainMenu
		MainMenu window = new MainMenu();
		window.frame.setVisible(true);
	}
}

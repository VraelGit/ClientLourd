package PPE;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.List;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ListCellRenderer;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UserAccount extends JFrame {

	private JPanel contentPane;	
	private JTable tab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccount frame = new UserAccount();
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
	public UserAccount() {
		MySQLCon sqlc1 = new MySQLCon();
		ArrayList<String> usr = sqlc1.getUsername();
		ArrayList<String> uActif = sqlc1.ActivAcc();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Création liste pour afficher e-mails utilisateurs
		List listUsr = new List();
		listUsr.setBounds(10, 10, 150, 241);
		contentPane.add(listUsr);	
				
		for(String x : usr)
		{
			listUsr.add(x);
		}
		
		//Création zone de texte sous boutons
		JLabel lblUsr = new JLabel("");
		lblUsr.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsr.setVerticalAlignment(SwingConstants.TOP);
		lblUsr.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsr.setBounds(199, 44, 225, 42);
		contentPane.add(lblUsr);
		
		//Création liste pour afficher si utilisateurs activés ou non
		List listUActif = new List();	
		listUActif.setBounds(166, 10, 27, 241);
		contentPane.add(listUActif);

		for(String x : uActif){
			listUActif.add(x);
		}

		JButton btnOk = new JButton("Activer");
		btnOk.setBounds(199, 10, 110, 23);
		contentPane.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedUsr = listUsr.getSelectedItem();	
				ArrayList<String> uActifNew = new ArrayList<String>();
				sqlc1.activateUsrAcc(selectedUsr);

				if(selectedUsr == null){
					lblUsr.setText("Sélectionnez un compte svp");	
				}else{
					lblUsr.setText("Activation réussie / Compte déjâ activé");
					listUActif.removeAll();
					
					uActifNew = sqlc1.ActivAcc();

					for(String x : uActifNew){
						listUActif.add(x);
					}
				}
			}
		});
				
		JButton btnBan = new JButton("Désactiver");
		btnBan.setBounds(319, 10, 110, 23);
		contentPane.add(btnBan);
		
		btnBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Même ActionListener que pour btnOk sauf qu'on utilise la fonction deactivateUsrAcc()
				String selectedUsr = listUsr.getSelectedItem();
				ArrayList<String> uActifNew = new ArrayList<String>();
				sqlc1.deactivateUsrAcc(selectedUsr);

				if(selectedUsr == null){
					lblUsr.setText("Sélectionnez un compte svp");
				}else{
					lblUsr.setText("Désactivation réussie / Compte déjâ désactivé");
					listUActif.removeAll();

					uActifNew = sqlc1.ActivAcc();	
					
					for(String x : uActifNew){
						listUActif.add(x);
					}	
				}
			}
		});
		
		//Création scrollPane et ajout tableau à l'intérieur
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 111, 225, 140);
		contentPane.add(scrollPane);
		
		tab = new JTable();
		tab.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setViewportView(tab);
	}
}

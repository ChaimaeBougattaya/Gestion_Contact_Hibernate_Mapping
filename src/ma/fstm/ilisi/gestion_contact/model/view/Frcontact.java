package ma.fstm.ilisi.gestion_contact.model.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ma.fstm.ilisi.gestion_contact.model.bo.Contact;
import ma.fstm.ilisi.gestion_contact.model.controler.Controler_contact;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Frcontact extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JTextField txtTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Frcontact frame = new Frcontact();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frcontact(First first) {
		setTitle("Ajouter un nouveau contact");
		
		setResizable(false);
		setType(Type.UTILITY);
		setBounds(100, 100, 495, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom :");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblNewLabel.setBounds(119, 49, 88, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom :");
		lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblNewLabel_1.setBounds(119, 92, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email :");
		lblNewLabel_2.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblNewLabel_2.setBounds(119, 137, 88, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 T\u00E9l :");
		lblNewLabel_3.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblNewLabel_3.setBounds(119, 174, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNom = new JTextField();
		txtNom.setBounds(236, 48, 151, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(236, 89, 151, 20);
		contentPane.add(txtPrenom);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(236, 134, 151, 20);
		contentPane.add(txtEmail);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(236, 171, 151, 20);
		contentPane.add(txtTel);
		
		JButton btnAjouter = new JButton("Ajouter");
		
		btnAjouter.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
		btnAjouter.setBounds(189, 270, 96, 25);
		contentPane.add(btnAjouter);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
		lblType.setBounds(119, 212, 88, 19);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Professionnel", "Amical", "Familiale"}));
		comboBox.setBounds(236, 211, 151, 22);
		contentPane.add(comboBox);
		
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact c  = new Controler_contact().ajouter(txtNom.getText(),txtPrenom.getText(),txtEmail.getText(),txtTel.getText(),comboBox.getSelectedItem().toString());
				if(c==null)
					JOptionPane.showMessageDialog(null,"Saisir des données valides !!");
				else
				{
					JOptionPane.showMessageDialog(null,"contact inserted successfuly");
					setVisible(false);
					first.addRow(c);
				}
			}
		});
	}
}

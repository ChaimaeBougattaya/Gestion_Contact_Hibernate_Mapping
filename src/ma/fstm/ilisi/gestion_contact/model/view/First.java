package ma.fstm.ilisi.gestion_contact.model.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ma.fstm.ilisi.gestion_contact.model.controler.Controler_contact;
import ma.fstm.ilisi.gestion_contact.model.bo.*;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class First extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private Object[] colum = {"ID","Nom","Prénom","N°Tél","Email","type"}; 
	private Object[] row = new Object[6];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First frame = new First();
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
	public First() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JButton btnNewButton = new JButton("ajouter contact");
		btnNewButton.setBackground(new Color(244, 164, 96));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Frcontact(First.this).setVisible(true);
				
			}
		});
		btnNewButton.setBounds(195, 31, 128, 36);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimerContact = new JButton("supprimer contact");
		btnSupprimerContact.setBackground(new Color(244, 164, 96));
		btnSupprimerContact.setBounds(343, 31, 173, 36);
		contentPane.add(btnSupprimerContact);
		
		JButton btnModifierContact = new JButton("modifier contact");
		btnModifierContact.setBackground(new Color(244, 164, 96));
		btnModifierContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = table.getSelectedRow();
				if(ind>=0)
				{
					Contact c = new Contact();
					c.setId(Long.parseLong(table.getModel().getValueAt(ind, 0).toString()));
					c.setNom(table.getModel().getValueAt(ind, 1).toString());
					c.setPrenom(table.getModel().getValueAt(ind, 2).toString());
					c.setTel(table.getModel().getValueAt(ind, 3).toString());
					c.setEmail(table.getModel().getValueAt(ind, 4).toString());
					new Frcontactupdate(First.this,c,ind).setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null, "il faut selectionner une ligne dans la table");
			}
		});
		btnModifierContact.setBounds(537, 31, 128, 36);
		contentPane.add(btnModifierContact);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 96, 798, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(colum);
		table.setModel(model);
		
		setDataTable(new Controler_contact().Retrieve_Contacts());
		
		btnSupprimerContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind = table.getSelectedRow();
				if(ind>=0)
				{			
					int option = JOptionPane.showConfirmDialog(First.this, "vous voulez vraiment supprimer ce contact ?");
					if(option == 0)//YES
					{
						long id=Long.parseLong(table.getModel().getValueAt(ind, 0).toString());
						System.out.println("id selected = "+id);
						String rep = new Controler_contact().delete(id);
						JOptionPane.showMessageDialog(null,rep);
						model.removeRow(ind);
					}
				}
				else
					JOptionPane.showMessageDialog(null, "il faut selectionner une ligne dans la table");
			}
		});
	}

	public void setDataTable(Collection<Contact> it) {
			while (model.getRowCount()>0)model.removeRow(0);
			for(Contact temp : it) {
				row[0]=temp.getId();
	            row[1]=temp.getNom();
	            row[2]=temp.getPrenom();
	            row[3]=temp.getTel();
	            row[4]=temp.getEmail();
	            row[5]=temp.getType().getTitre();   
	            model.addRow(row);
			}
	}
	
	public void addRow(Contact temp)
	{
		System.out.println("here add row ");
		
		row[0]=temp.getId();
        row[1]=temp.getNom();
        row[2]=temp.getPrenom();
        row[3]=temp.getTel();
        row[4]=temp.getEmail();
        row[5]=temp.getType().getTitre();
        
        model.addRow(row);
	}
	public void updateRow(Contact temp,int ind)
	{
		System.out.println("here update row ");
        table.getModel().setValueAt(temp.getId(), ind, 0);
        table.getModel().setValueAt(temp.getNom(), ind, 1);
        table.getModel().setValueAt(temp.getPrenom(), ind, 2);
        table.getModel().setValueAt(temp.getTel(), ind, 3);
        table.getModel().setValueAt(temp.getEmail(), ind, 4);
        table.getModel().setValueAt(temp.getType().getTitre(), ind, 5);
        
	}

}

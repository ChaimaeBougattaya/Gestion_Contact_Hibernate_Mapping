package ma.fstm.ilisi.gestion_contact.model.bo;

import java.util.Set;

public class Type {
	private long id;
	private String titre;
	Set<Contact> contacts;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public Type(int id, String titre, Set<Contact> contacts) {
		super();
		this.id = id;
		this.titre = titre;
		this.contacts = contacts;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

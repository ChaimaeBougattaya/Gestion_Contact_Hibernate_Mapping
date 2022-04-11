package ma.fstm.ilisi.gestion_contact.model.bo;

public class Contact {
	private long id;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private Type type;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Contact(int id, String nom, String prenom, String tel, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

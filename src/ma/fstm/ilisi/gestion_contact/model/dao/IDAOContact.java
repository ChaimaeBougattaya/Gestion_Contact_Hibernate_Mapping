package ma.fstm.ilisi.gestion_contact.model.dao;
import java.util.Collection;

import ma.fstm.ilisi.gestion_contact.model.bo.*;

public interface IDAOContact {
	public Contact Create(Contact c);
	public Contact update(Contact c);
	public String delete(long id);
	Collection<Contact> retrieve();

}

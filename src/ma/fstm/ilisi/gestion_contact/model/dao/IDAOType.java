package ma.fstm.ilisi.gestion_contact.model.dao;

import java.util.Collection;

import ma.fstm.ilisi.gestion_contact.model.bo.Type;

public interface IDAOType {
	public Collection<Type> retrieve();
	public long retrieveOne(String titre);
}

package ma.fstm.ilisi.gestion_contact.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.fstm.ilisi.gestion_contact.model.bo.Contact;
import ma.fstm.ilisi.gestion_contact.model.bo.Type;

public class DAOType implements IDAOType{

	@Override
	public Collection<Type> retrieve() {
	
		SessionFactory sessionFactory=UtilHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		return session.createQuery("from Type").list();
	}

	@Override
	public long retrieveOne(String titre) {
		SessionFactory sessionFactory=UtilHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		return((Type) session.createQuery("from Type where titre = :t").setParameter("t", titre).list().get(0)).getId();
		
	}
	
	public static void main(String[] args) {
		
		/**
		 * Collection<Type> it = new DAOType().retrieve();
		for(Type c : it)
			System.out.println(c.getId() + " "+ c.getTitre());
		 
		 */
		System.out.println(new DAOType().retrieveOne("Professionnel"));
		
		
	}
}

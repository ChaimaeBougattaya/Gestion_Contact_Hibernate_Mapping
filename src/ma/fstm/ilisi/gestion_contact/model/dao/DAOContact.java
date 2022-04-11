package ma.fstm.ilisi.gestion_contact.model.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ma.fstm.ilisi.gestion_contact.model.bo.Contact;

public class DAOContact implements IDAOContact {

	@Override
	public Contact Create(Contact c) {
		SessionFactory sessionFactory=UtilHibernate.getSession();
		Session session=sessionFactory.openSession();
				
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(c);
			tx.commit();
			List<Contact> list = (List<Contact>) this.retrieve();
			long id=list.get(list.size()-1).getId();
			System.out.println("id inserted id : "+id);
			System.out.println("Contact inserted successsfuly ");
			session.close();
			return c;
		}
		catch(Exception exp) {
			tx.rollback();
			System.out.println("EROR while inserting");
			return null;
		}
		
	}

	@Override
	public Contact update(Contact c) {
		SessionFactory sessionFactory=UtilHibernate.getSession();
		Session session=sessionFactory.openSession();

		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			
			session.update(c);
			tx.commit();
			session.close();
			System.out.println("Contact updated successsfuly ");
			return c;
			
		}catch(Exception exp) {
			tx.rollback();
			System.out.println(" EROR while updating");
			return null;
		}
	}

	@Override
	public String delete(long id) {
		
		SessionFactory sessionFactory=UtilHibernate.getSession();
		Session session=sessionFactory.openSession();
		
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Contact c=new Contact();
			c.setId(id);
			session.delete(c);
			tx.commit();
			session.close();
			return "Contact deleted successsfuly ";
			
		}catch(Exception exp) {
			tx.rollback();
			return "EROR while deleting";
		}
	}
	
	@Override
	public Collection<Contact> retrieve() {
	
		SessionFactory sessionFactory=UtilHibernate.getSession();
		Session session=sessionFactory.openSession();

		return session.createQuery("from Contact").list();
	}

}

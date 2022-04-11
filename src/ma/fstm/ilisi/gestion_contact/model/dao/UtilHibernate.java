package ma.fstm.ilisi.gestion_contact.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UtilHibernate {
	private static SessionFactory session;

	static {
		try {
			Configuration config=new Configuration();
			config.configure("/ma/fstm/ilisi/gestion_contact/model/dao/hibernate.cfg.xml");
			session=config.buildSessionFactory();
			
			}catch(HibernateException exep) {
				System.out.println("error");
				exep.printStackTrace();
		}

	}
	public static SessionFactory getSession() {
		return session;
	}

	public static void setSession(SessionFactory session) {
		UtilHibernate.session = session;
	}
}

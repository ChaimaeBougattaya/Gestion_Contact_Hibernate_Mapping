package ma.fstm.ilisi.gestion_contact.model.controler;
import java.util.Collection;

import ma.fstm.ilisi.gestion_contact.model.bo.*;
import ma.fstm.ilisi.gestion_contact.model.dao.*;

public class Controler_contact {
	
	DAOContact daoC=new DAOContact();
	
	public Collection<Contact> Retrieve_Contacts() {
		return new DAOContact().retrieve();
	}
	
	public Contact ajouter(String text, String text2, String text3, String text4, String type) {
		
		if(text.length()!=0 && text2.length()!=0 && text3.length()!=0 && text4.length()!=0 && type.length()!=0 )
		{
			if(text4.length()==13)
			{
				Type t = new Type();
				long id = new DAOType().retrieveOne(type);
				t.setTitre(type);
				t.setId(id);
				
				Contact c = new Contact();
				c.setNom(text);
				c.setPrenom(text2);
				c.setEmail(text3);
				c.setTel(text4);
				c.setType(t);
			
				return daoC.Create(c);
			}else
				{
					System.out.println("saisir un N°Tel correcte");
					return null;
				}
		}else
		{
			System.out.println("saisir les informatios ");
			return null;
		}
	}
	
	public String delete(long i)
	{
		return new DAOContact().delete(i);
	}
	
	public Contact update(long newid , String text, String text2, String text3, String text4, String type)
	{
		
		if(text.length()!=0 && text2.length()!=0 && text3.length()!=0 && text4.length()!=0 && type.length()!=0 )
		{
			if(text4.length()==13)
			{
				Type t = new Type();
				long id = new DAOType().retrieveOne(type);
				t.setTitre(type);
				t.setId(id);
				
				Contact c = new Contact();
				c.setId(newid);
				c.setNom(text);
				c.setPrenom(text2);
				c.setEmail(text3);
				c.setTel(text4);
				c.setType(t);
			
				return daoC.update(c);
			}else
				{
					System.out.println("saisir un N°Tel correcte");
					return null;
				}
		}else
		{
			System.out.println("saisir les informatios ");
			return null;
		}
		
	}

}

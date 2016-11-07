package models;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class SessionConfig {

	  static SessionFactory  fac=null;


	public SessionConfig()
	{
		try
		{
			fac=new Configuration().configure("booking_hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
		
		public static  Session getSession()
		{
			return fac.openSession();
		}

}

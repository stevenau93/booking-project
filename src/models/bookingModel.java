package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class bookingModel {
	SessionFactory fac=null;
	public bookingModel()
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
	public Session getSession()
	{
		return fac.openSession();
	}
	
	public List<entities.Airport>getOrigin()
	{
		List<entities.Airport> list=null;
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		 String hql="FROM Airport";
		 Query query=session.createQuery(hql);
		 list=query.list();
		 trans.commit();
		 return list;
	}
	
	public List<entities.Airport>getDestination(String originLocation)
	{
		List<entities.Airport>list=null;
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		String hql="FROM Airport A Where A.city !=:originLocation";
		Query query=session.createQuery(hql);
		query.setParameter("originLocation",originLocation);
		list=query.list();
		trans.commit();
		return list;
	}
	
}

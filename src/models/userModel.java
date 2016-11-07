package models;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Register;
import entities.Profile;


public class userModel {
	SessionFactory fac=null;


	public userModel()
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


	
	public List<entities.Register> getUsers(String username)
	{					
		List<entities.Register>result=null;
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		String hql="FROM Register R where R.username=:username";
		Query query=session.createQuery(hql);
		query.setParameter("username",username);		
		result=query.list();	
		trans.commit();		
		return result;
	}
	
	public Register getByUsername(String username)
	{
		Session session=getSession();
		Transaction trans=session.beginTransaction();
	    Register reg=(Register)session.get(Register.class,username);
	    trans.commit();
	    return reg;
	}
	
	
	public void insertUsers(Register user)
	{
		try
		{
			Session session=getSession();
			Transaction trans=session.beginTransaction();
			session.persist(user);
			trans.commit();				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void insertProfile(Profile profile)
	{
		try
		{
			Session session=getSession();
			Transaction trans=session.beginTransaction();
			session.persist(profile);
			trans.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public List<entities.Profile> emailIsExist(String email)
	{
		List<entities.Profile>result=null;
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		String hql="FROM Profile P where P.email=:email";
		Query query=session.createQuery(hql);
		query.setParameter("email",email);		
		result=query.list();	
		trans.commit();		
		return result;
	}
	
}






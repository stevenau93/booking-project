package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Profile;
import entities.Register;


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
	
	public Profile getProfileByUsername(String username)
	{
		Session session=getSession();
		Transaction trans=session.beginTransaction();
		Profile profile=(Profile)session.get(Profile.class,username);
		trans.commit();
		return profile;
	}
	
	
	public void insertUsers(Register user)//insert username,password into Register table
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
	
	public void insertProfile(Profile profile)//insert username and mail into Profile table
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
	
	
	
	public byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
	{
		SecureRandom sr=SecureRandom.getInstance("SHA1PRNG","SUN");
		byte[] salt=new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
	
	public String getSecurePassword(String passwordToHash,byte[]salt)
	{
		String generatedPassword=null;
		try
		{
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(salt);
			byte[] bytes=md.digest(passwordToHash.getBytes());
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<bytes.length;i++)
			{
				sb.append(Integer.toString((bytes[i]&0xff)+0x100,16).substring(1));
			}
			generatedPassword=sb.toString();
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return generatedPassword;
	}
	
	
}






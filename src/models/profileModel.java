package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Profile;



public class profileModel {
	SessionFactory fac=null;


	public profileModel()
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
		
			
		public boolean updateProfile(Profile profile)
		{
			try
			{
				Session session=getSession();
				Transaction trans=session.beginTransaction();
				Profile userProfile=(Profile)session.get(Profile.class,profile.getUsername());
				if(userProfile!=null)
				{				
					userProfile.setFirstName(profile.getFirstName());
					userProfile.setLastName(profile.getLastName());
					userProfile.setEmail(profile.getEmail());
					userProfile.setPhoneNumber(profile.getPhoneNumber());
					userProfile.setPassport(profile.getPassport());
					userProfile.setIdentityCard(profile.getIdentityCard());
					userProfile.setAddress(profile.getAddress());
					userProfile.setCity(profile.getCity());
					userProfile.setState(profile.getState());
					userProfile.setPostalCode(profile.getPostalCode());
					userProfile.setCity(profile.getCity());					
					session.update(userProfile);
					trans.commit();
				}
				return true;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return false;
		
		}
}

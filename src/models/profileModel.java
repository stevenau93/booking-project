package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Profile;
import entities.Register;



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
		
		public Profile getProfileByUsername(String username)
		{
			Session session=getSession();
			Transaction trans=session.beginTransaction();
			Profile profile=(Profile)session.get(Profile.class,username);
			return profile;
		}
		
		public boolean updatePassword(Register reg)
		{
			try
			{
			Session session=getSession();
			Transaction trans=session.beginTransaction();
			Register register=(Register)session.get(Register.class,reg.getUsername());
			if(register != null)
			{
				register.setPassword(reg.getPassword());
				register.setSalt(reg.getSalt());
				session.update(register);
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

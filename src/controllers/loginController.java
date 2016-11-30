package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Profile;
import entities.Register;
import models.userModel;
/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public loginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		userModel userM=new userModel();	
		String btn=request.getParameter("btn");
			
		if(btn.equals("Sign in"))
		{			
			String username=request.getParameter("txtUsername");
			String password=request.getParameter("txtPassword");						
			
			List<Register> result=userM.getUsers(username);
			if(result.size()>0)
			{
			for(Register reg:result)
			{
				
				byte[] salt=reg.getSalt();
				String getGeneratedPassword=userM.getSecurePassword(password,salt);
			
				if(username.equals(reg.getUsername()) &&getGeneratedPassword.equals(reg.getPassword()))
				{
					Register register=userM.getByUsername(username);	
					Profile profile=userM.getProfileByUsername(username);
					session.setAttribute("username",username);
					session.setAttribute("register",register);
					session.setAttribute("profile", profile);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/Home.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.println("password is incorrect.");
				}
			}
			}
			else
			{
				out.println("username do not exist.");
			}
			}			
		
		else if(btn.equals("Sign up"))
		{
			String username_register=request.getParameter("txtUsername_register");
			String password_register=request.getParameter("txtPassword_register");
			String permission="user";
			String email=request.getParameter("txtMail");			
			java.util.Date date=new java.util.Date();						
			
			
			String generatedPassword=null;
			byte[] salt = null;
			
			try 
			{
				salt = userM.getSalt();
				generatedPassword=userM.getSecurePassword(password_register,salt);
			} 
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			} catch (NoSuchProviderException e) 
			{
				e.printStackTrace();
			}
			
			
			List<Register>result=userM.getUsers(username_register);
			if(result.size()!=0)
			{				
				out.println("Username is exist");
			}
			else
			{
				List<Profile>existEmail=userM.emailIsExist(email);
				if(existEmail.size()==0)
				{
				Register user=new Register(username_register,generatedPassword,salt,permission,date);
				Profile userProfile=new Profile(username_register,"","",email,"","","","","","","","");
				userM.insertUsers(user);
				userM.insertProfile(userProfile);
				
				
				Register register=userM.getByUsername(username_register);	
				Profile profile=userM.getProfileByUsername(username_register);
				
				session.setAttribute("username",username_register);
				session.setAttribute("register",register);
				session.setAttribute("profile",profile);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/Home.jsp");
				rd.forward(request, response);	
				}
				else
				{
					out.println("Email is exist");
				}
			}
			
		}
	
	}

}

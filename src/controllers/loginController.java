package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PrintWriter out=response.getWriter();
		userModel userM=new userModel();	
		String btn=request.getParameter("btn");
			
		if(btn.equals("Sign in"))
		{			
			String username  =request.getParameter("txtUsername");
			String password=request.getParameter("txtPassword");
						
			List<Register> result=userM.getUsers(username);
			
			for(Register reg:result)
			{
				
				byte[] salt=reg.getSalt();
				String getGeneratedPassword=userM.getSecurePassword(password,salt);
			
				if(username.equals(reg.getUsername()) &&getGeneratedPassword.equals(reg.getPassword()))
				{
					Register register=userM.getByUsername(username);	
					Profile profile=userM.getProfileByUsername(username);
					request.setAttribute("username",register);
					request.setAttribute("profile", profile);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/user-profile-settings.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.println("username or password is incorrect.");
				}
			}			
		}
		else if(btn.equals("Sign up"))
		{
			String username=request.getParameter("txtUsername_register");
			String password=request.getParameter("txtPassword_register");
			
			byte[] salt = null;
			try 
			{
				salt = userM.getSalt();
			} 
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			} catch (NoSuchProviderException e) 
			{
				e.printStackTrace();
			}
			
			String generatedPassword=userM.getSecurePassword(password,salt);
			String permission="user";
			String email=request.getParameter("txtMail");			
			java.util.Date date=new java.util.Date();						
			List<Register>result=userM.getUsers(username);
			if(result.size()!=0)
			{				
				out.println("Username is exist");
			}
			else
			{
				List<Profile>existEmail=userM.emailIsExist(email);
				if(existEmail.size()==0)
				{
				Register user=new Register(username,generatedPassword,salt,permission,date);
				Profile userProfile=new Profile(username,"","",email,"","","","","","","","");
				userM.insertUsers(user);
				userM.insertProfile(userProfile);
				Register register=userM.getByUsername(username);	
				Profile profile=userM.getProfileByUsername(username);
				request.setAttribute("username",register);
				request.setAttribute("profile",profile);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/user-profile-settings.jsp");
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

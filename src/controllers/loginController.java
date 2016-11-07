package controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
		
				if(username.equals(reg.getUsername()) &&password.equals(reg.getPassword()))
				{
					Register register=userM.getByUsername(username);					
					request.setAttribute("username",register);
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
				else
				{
					response.sendRedirect("login-register-normal.jsp");
				}
			}			
		}
		else if(btn.equals("Sign up"))
		{
			String username=request.getParameter("txtUsername_register");
			String password=request.getParameter("txtPassword_register");
			String salt="later";
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
				Register user=new Register(username,password,salt,permission,date);
				Profile profile=new Profile(username,"","",email,"","","","","","","","");
				userM.insertUsers(user);
				userM.insertProfile(profile);
				Register register=userM.getByUsername(username);					
				request.setAttribute("username",register);
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
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

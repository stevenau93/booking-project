package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Profile;
import entities.Register;
import models.profileModel;
import models.userModel;

/**
 * Servlet implementation class profileController
 */
@WebServlet("/profileController")
public class profileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	HttpSession session=request.getSession();
	PrintWriter out=response.getWriter();
	profileModel profileM=new profileModel();
	userModel userM=new userModel();
	String btn=request.getParameter("btn");	
	
	String userName=(String)session.getAttribute("username");
	String firstName=request.getParameter("txtFirstName");
	String lastName=request.getParameter("txtLastName");
	String Mail=request.getParameter("txtMail");
	String Phone=request.getParameter("txtPhone");
	String Passport=request.getParameter("txtPassport");
	String identityCard=request.getParameter("txtIdentityCard");
	String Address=request.getParameter("txtAddress");
	String City=request.getParameter("txtCity");
	String State=request.getParameter("txtState");
	String postalCode=request.getParameter("txtPostalCode");
	String Country=request.getParameter("txtCountry");
	String Password=request.getParameter("txtPassword");
	String newPassword=request.getParameter("txtNewPassword");
	String reType=request.getParameter("txtRetype");
	
	
	if(btn.equals("Save Changes"))
	{
	
		Profile profile=new Profile(userName,firstName,lastName,Mail,Phone,Passport,identityCard,Address,City,State,postalCode,Country);
		boolean result=profileM.updateProfile(profile);
		if(result==true)
		{
			System.out.println("update success");
		}
		else
		{
			System.out.println("update fail");
		}
	}
	
	if(btn.equals("Change Password"))
	{	
		List<Register> result=userM.getUsers(userName);
		for(Register reg:result )
		{
		String currentPassword=userM.getSecurePassword(Password,reg.getSalt());
		
		if(currentPassword.equals(reg.getPassword()))
		{
			if(!newPassword.equals(reType))
			{
				out.println("Password is not match");
			}
			else
			{
				byte[] salt=null;
				String generatedNewPassword=null;
				try 
				{
					salt = userM.getSalt();
					generatedNewPassword=userM.getSecurePassword(newPassword, salt);
					Register register=new Register(userName,generatedNewPassword,salt,reg.getPermisstion(),reg.getCreateDate());
					profileM.updatePassword(register);
					out.println("update password successful");
				} catch (NoSuchAlgorithmException | NoSuchProviderException e) 
				{
					e.printStackTrace();
					out.println("update password fail");
				}									
			}
		}
		else
		{
			out.println("Current password wrong");
		}
		}
		}
	
}
}

package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Profile;
import models.profileModel;

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
	profileModel profileM=new profileModel();
	String btn=request.getParameter("btn");	
	String userName="minhphat18";
	String firstName=request.getParameter("txtFirstName");
	String lastName=request.getParameter("txtLastName");
	String Mail=request.getParameter("txtMail");
	String Phone=request.getParameter("txtPhone");
	String Passport=request.getParameter("txtPassport");
	String identityCard=request.getParameter("txtIndentityCard");
	String Address=request.getParameter("txtAddress");
	String City=request.getParameter("txtCity");
	String State=request.getParameter("txtState");
	String postalCode=request.getParameter("txtPostalCode");
	String Country=request.getParameter("txtCountry");
	
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
	
}
}

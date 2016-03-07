package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginController")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Sessions Login</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Login <small>Heal</small></h1>");
		out.println("	</div>");
		
		String error = (String) request.getAttribute("error");
		if (error != null)
			out.println("<p class=\"text-danger lead\">" + error + "</p>");
		
		// Page-Specific Content
		out.println("<form action=\"Login\" method=\"post\" >");
		out.println("   Username: <input type=\"text\" name=\"username\" /> <br />");
		out.println("   Password: <input type=\"password\" name=\"password\" /> <br />");
		out.println("   <input type=\"submit\" value=\"Login\" />");
		
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
	
		ArrayList<HealUsers> healUsers = (ArrayList<HealUsers>) getServletContext().getAttribute("HealUsers");
		
		for ( HealUsers user: healUsers){
			PrintWriter out = response.getWriter();
			
			if (username != null && username.equalsIgnoreCase(user.getEmail())
					&& password != null && password.equalsIgnoreCase(user.getPassword()) ){
			
				// Create a Session Variable named Username
				HttpSession session = request.getSession();
				session.setAttribute("CurrentUser", user);
				
				out.print("good:"+user);
			    //Redirect to the Member's Only page
				response.sendRedirect(".MyHeal");
				//response.sendRedirect("../Sessions/Members");
				
				return;
			 }
		out.println("");
			
		}
		request.setAttribute("error", "Invalid Username and/or Password");
		doGet(request, response);
	
		
		
	}

}








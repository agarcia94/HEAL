package controller;

import java.io.IOException;

import model.BloodProfile;
import model.EmailSender;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommunicationController
 */
@WebServlet("/CommunicationController")
public class CommunicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunicationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
//		if(this.getServletContext().getAttribute("current_profile") == null)
//		{
//			String user = "Andrew";
//			this.getServletContext().setAttribute("current_profile", user);
//		} 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BloodStat b = new BloodStat();
		BloodProfile b = (BloodProfile) (this.getServletContext().getAttribute("current_profile"));
		String message = "Greetings,\n\nThis a message from HEAL Blood check system.\n\nUser x's " 
							+ b.toString() + "\n\nHave a nice day human,\nHEAL";		
		request.setAttribute("BloodStatResult", this.getServletContext().getAttribute("current_profile"));
		request.setAttribute("emailMessage", message);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Communication.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmailSender emailSender = new EmailSender();
		String sendAddress = (String) request.getParameter("emailAddress");
		String sendMessage = (String) request.getParameter("emailMessage");
		emailSender.send(sendAddress, sendMessage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Display.jsp");
		dispatcher.forward(request, response);
	}
}

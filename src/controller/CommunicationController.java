package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.BloodStat;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BloodStat b = new BloodStat();
		String message = "Greetings,\n\nThis a message from HEAL Blood check system.\n\nUser x's " 
							+ b.toString() + "\n\nHave a nice day human,\nHEAL";		
		request.setAttribute("BloodStatResult", b);
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

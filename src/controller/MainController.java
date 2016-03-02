package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.VoiceProcessor;


/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		if(this.getServletContext().getAttribute("username") == null)
//		{
//			String user = "Andrew";
//			this.getServletContext().setAttribute("username", user);
//		} 
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username", "Andrew");
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VoiceProcessor recordVoice = null;
		recordVoice = new VoiceProcessor();
		//System.out.println("Voice result: " + recordVoice.getVoiceResult());
				
		if(recordVoice.getVoiceResult().contains("blood") || recordVoice.getVoiceResult().contains("check"))
			//request.getRequestDispatcher( "/BloodCheckController" ).forward(request, response);
			request.getRequestDispatcher("/WEB-INF/BloodCheck.jsp" ).forward(request, response);
		else{
			System.out.println("Invalid voice recognized. Try again.");
			doPost(request, response);
		}
			
	}

}

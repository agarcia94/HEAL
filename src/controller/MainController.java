package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BloodStat;
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
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//BloodStat stat = new BloodStat();
		VoiceProcessor recordVoice = null;
		recordVoice = new VoiceProcessor();
		//System.out.println("Voice result: " + recordVoice.getVoiceResult());
		
		
		if(recordVoice.getVoiceResult().contains("blood") || recordVoice.getVoiceResult().contains("check"))
			request.getRequestDispatcher( "/BloodCheckController" ).forward(request, response);
		else{
			System.out.println("Invalid voice recognized. Try again.");
			doGet(request, response);
		}
		//response.sendRedirect("https://google.com"); 
			
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

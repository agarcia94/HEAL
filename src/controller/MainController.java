package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.jl.decoder.JavaLayerException;

import java.time.*;

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
		VoiceProcessor recordVoice = new VoiceProcessor();
		
		LocalTime time1 = LocalTime.now();
		Duration threeSeconds = Duration.ofSeconds(3);
		
		recordVoice.captureAudio();
		System.out.println("Capturing audio");
		
		while(LocalTime.now().isBefore(time1.plus(threeSeconds))){
		}
		
		recordVoice.stopCapture();
		
		System.out.println("Finished audio capture");
		
		if(recordVoice.getVoiceResult().contains("blood") || recordVoice.getVoiceResult().contains("check")){
			
			try {
				recordVoice.playResponse("Okay, moving to the blood check module.");
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/BloodCheck.jsp").forward(request, response);
		}
			
		
		if(recordVoice.getVoiceResult().contains("user") || recordVoice.getVoiceResult().contains("profile")
				|| recordVoice.getVoiceResult().contains("history")){
			try{
				recordVoice.playResponse("Okay, moving to your user profile.");
			}catch(Exception o){
				o.printStackTrace();
			}
			
			//user attribute retrieved from MyHeal
			//username attribute used for main.jsp
			request.setAttribute("username", this.getServletContext().getAttribute("user"));
			//request.setAttribute("bloodProfiles", request.getAttribute("bloodProfiles"));
			request.getRequestDispatcher("/DisplayController").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username", request.getAttribute("user")); //for the jsp to reference
		this.getServletContext().setAttribute("user", request.getAttribute("user")); //useful for display module
		this.getServletContext().setAttribute("bloodProfiles", request.getAttribute("bloodProfiles")); //useful for display module
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
		
	}

}

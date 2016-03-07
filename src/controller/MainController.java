package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.speech.freetts.VoiceManager;

import java.time.*;

import model.VoiceProcessor;
import model.VoiceResponse;


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
		//request.setAttribute("username", "Andrew");
		request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		boolean validVoice = false;
//		boolean voiceCaptureStarted = false;
//		
//		VoiceProcessor recordVoice = null;
//		recordVoice = new VoiceProcessor();
//				
//		LocalTime time1 = LocalTime.now();
//		Duration eightSeconds = Duration.ofSeconds(8);
//		
//		recordVoice.captureAudio();
//		voiceCaptureStarted = true;
//		request.setAttribute("capture_start", voiceCaptureStarted);
//		
//		while(LocalTime.now().isBefore(time1.plus(eightSeconds))){
//		}
//		
//		recordVoice.stopCapture();
//		
//		VoiceResponse voiceReplay = new VoiceResponse();
//		voiceReplay.setVoiceResult(recordVoice.getVoiceResult());
//		voiceReplay.replayVoiceCommand();
//		
//		
//		if(recordVoice.getVoiceResult().contains("blood") || recordVoice.getVoiceResult().contains("check")){
//			validVoice = true;
//			request.setAttribute("validVoice", validVoice);
//			
//			voiceReplay.setVoice(VoiceManager.getInstance().getVoice("kevin16"));
//			voiceReplay.getVoice().allocate();			
//			voiceReplay.getVoice().speak("Valid voice recognized. Moving to blood check.");
//			voiceReplay.getVoice().deallocate();
//			
//			request.getRequestDispatcher("/WEB-INF/BloodCheck.jsp" ).forward(request, response);
//		}
//		else{			
//			voiceReplay.setVoice(VoiceManager.getInstance().getVoice("kevin16"));
//			voiceReplay.getVoice().allocate();			
//			voiceReplay.getVoice().speak("Invalid voice command. Try again.");
//			voiceReplay.getVoice().deallocate();
//			
//			request.setAttribute("validVoice", validVoice);
//			doPost(request, response);
//		}
//		
//		request.setAttribute("result", "You said " + recordVoice.getVoiceResult());

						

			
	}

}

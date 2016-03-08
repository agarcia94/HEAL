package controller;

//by Raymond Wu

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.jl.decoder.JavaLayerException;

import com.sun.speech.freetts.VoiceManager;

import model.BloodProfile;
import model.VoiceProcessor;
import model.VoiceResponse;

@WebServlet("/BloodCheckController")
@MultipartConfig
public class BloodCheckController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public BloodCheckController() 
    {
        super();
    }


	public void init(ServletConfig config) throws ServletException
	{
		//temporary, just for testing 
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher( "/WEB-INF/BloodCheck.jsp" ).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		VoiceProcessor recordVoice = null;
		recordVoice = new VoiceProcessor();
				
		LocalTime time1 = LocalTime.now();
		Duration threeSeconds = Duration.ofSeconds(3);
		
		recordVoice.captureAudio();
		System.out.println("Capturing audio");
		
		while(LocalTime.now().isBefore(time1.plus(threeSeconds))){
		}
		
		recordVoice.stopCapture();
		System.out.println("Finished audio capture");
		
//		VoiceResponse voiceReplay = new VoiceResponse();
//		voiceReplay.setVoiceResult(recordVoice.getVoiceResult());
//		voiceReplay.replayVoiceCommand();
		
		if(recordVoice.getVoiceResult().contains("generate")
				|| recordVoice.getVoiceResult().contains("blood") 
				|| recordVoice.getVoiceResult().contains("report")){
			Random rand = new Random();
			int randInt = rand.nextInt(3)+1;
			Scanner input = new Scanner(new File("C:\\CS437\\HEAL\\text files\\sample" + randInt+ ".txt"));
			String[] values = null;
			String info = "";
			
			while(input.hasNextLine()){
				info = input.nextLine();
			}
			
			values = info.split("/");
			
			int lipo = Integer.parseInt(values[0]);
			int tri = Integer.parseInt(values[1]);
			int rbc = Integer.parseInt(values[2]);
			int glu = Integer.parseInt(values[3]);
			int vit = Integer.parseInt(values[4]);
			
			//int currentUser = 1;
			int userID = (int)(request.getSession().getAttribute("userId"));
			
			Connection c = null;
			try{
	        	String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu02";
	            String username1= "cs320stu02";
	            String password1 = "8W!tefx3";
	            
	            c = DriverManager.getConnection( url, username1, password1 );
	        	
	            Statement stmt = c.createStatement();
	            
	            String insertProfile = "INSERT INTO  `cs320stu02`.`BloodProfile` (`id` , `userId` , `lipo`, `tri`,"
	            		+ "`rbc`, `glu`, `vit`)"
						+ "VALUES ( NULL , '" + userID + "' ,  '" + lipo + "' ,'" + tri + "' , '" + rbc + "' , '" 
	            		+ glu + "' , '" + vit + "')";
	            
	            stmt.execute(insertProfile);
	            VoiceProcessor voice = new VoiceProcessor();
	            voice.playResponse("Blood profile inserted into database");
	            //System.out.println("Blood profile inserted into database");
	            
			}catch(Exception e){
				e.printStackTrace();
			}
			
			BloodProfile current = new BloodProfile (userID,lipo,tri,rbc,glu,vit);
			//System.out.println(current);
			getServletContext().setAttribute("current_profile",current);
			
			ArrayList<BloodProfile> profiles = (ArrayList<BloodProfile>) (request.getSession().getAttribute("bloodProfiles"));
			profiles.add(current);
			request.getSession().setAttribute("bloodProfiles", profiles);
			
			input.close();
			
			try {
				recordVoice.playResponse(recordVoice.getVoiceResult() + "?Okay,generating blood status report.");
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			//request.getRequestDispatcher("/WEB-INF/Communication.jsp" ).forward(request, response);
			request.getRequestDispatcher("/CommunicationController" ).forward(request, response);
		}
		else{
			
			try {
				recordVoice.playResponse("Sorry,invalid voice command. Try again.");
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			doPost(request, response);
		}
		
//		Part filePart = request.getPart("blood_file");
//		InputStream fileContent = filePart.getInputStream();
//		BufferedReader fileContentReader = new BufferedReader(new InputStreamReader(fileContent));
//		StringBuilder out = new StringBuilder();
//		String line;
//		while ((line = fileContentReader.readLine()) != null)
//		{
//			out.append(line);
//		}
//		//outString is the complete string, needs to be seperated
//		//System.out.println(out.toString());
//		String outString = out.toString();
//		fileContentReader.close();
//		
//		//need to separate the string
//		String[] values = outString.split("/");
//		int lipo = Integer.parseInt(values[0]);
//		int tri = Integer.parseInt(values[1]);
//		int cells = Integer.parseInt(values[2]);
//		int glu = Integer.parseInt(values[3]);
//		int vit = Integer.parseInt(values[4]);
//		
//		int currentUser = 1; //filler for now
//		
//		BloodProfile current = new BloodProfile (currentUser,lipo,tri,cells,glu,vit);
//		getServletContext().setAttribute("current_profile",current);
//		
//		request.getRequestDispatcher("/WEB-INF/Display.jsp" ).forward(request, response);
	}	

}

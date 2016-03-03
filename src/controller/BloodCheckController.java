package controller;

//by Raymond Wu

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BloodProfile;

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
		Part filePart = request.getPart("blood_file");
		InputStream fileContent = filePart.getInputStream();
		BufferedReader fileContentReader = new BufferedReader(new InputStreamReader(fileContent));
		StringBuilder out = new StringBuilder();
		String line;
		while ((line = fileContentReader.readLine()) != null)
		{
			out.append(line);
		}
		//outString is the complete string, needs to be seperated
		//System.out.println(out.toString());
		String outString = out.toString();
		fileContentReader.close();
		
		//need to separate the string
		String[] values = outString.split("/");
		int lipo = Integer.parseInt(values[0]);
		int tri = Integer.parseInt(values[1]);
		int cells = Integer.parseInt(values[2]);
		int glu = Integer.parseInt(values[3]);
		int vit = Integer.parseInt(values[4]);
		
		int currentUser = 1; //filler for now
		
		BloodProfile current = new BloodProfile (currentUser,lipo,tri,cells,glu,vit);
		getServletContext().setAttribute("current_profile",current);
		
		request.getRequestDispatcher("/WEB-INF/Display.jsp" ).forward(request, response);
	}	

}

package controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

@WebServlet("/MyHeal")
public class MyHeal extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

//        try
//        {
//            Class.forName( "com.mysql.jdbc.Driver" );
//        	
//        }
//        catch( ClassNotFoundException e )
//        {
//            throw new ServletException( e );
//        }
        
        try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
		HttpSession session = request.getSession();
		session.getAttribute("CurrentUser");
		String CurrentUsers = (String) session.getAttribute("CurrentUser");
    	
		if (CurrentUsers == null){
        request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(
            request, response );
    	}else
    		
    		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward(
    		            request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        //List<Heal> notes = new ArrayList<Heal>();
    	ArrayList<BloodProfile> profiles= new ArrayList<BloodProfile>();

        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );
        
//        if(this.getServletContext().getAttribute("user") == null)
//        	this.getServletContext().setAttribute("user", username);
        
        
        String sql = "SELECT COUNT( id ) AS count, id AS id FROM HealUsers WHERE email = '"+ username +"' AND password = '" + password + "' ";
        
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu:3306/cs320stu02";
            String username1= "cs320stu02";
            String password1 = "8W!tefx3";
            
            c = DriverManager.getConnection( url, username1, password1 );
        	
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            rs.next();
            int count = rs.getInt("count");
            int id = rs.getInt("id");
            
            //System.out.print("hello");
            if (count == 1){ //if user exists in HealUsers database
            	HttpSession session = request.getSession();
            	session.setAttribute("CurrentUser", username);
            	session.setAttribute("userId", id);
    		
            	String sql2 = "SELECT * FROM BloodProfile WHERE userId = (select id from HealUsers where email='" + username + "' and password = '" + password + "')";
    	
            	rs = stmt.executeQuery( sql2 );
    		
            	while( rs.next() )
            	{
            		System.out.println("got blood profile");
//            		Heal note = new Heal();
//            		note.setId( rs.getInt( "id" ) );
//            		note.setTitle( rs.getString( "title" ) );
//            		note.setNotes( rs.getString( "notes" ) );
//               
//            		notes.add( note );
            		BloodProfile profile = new BloodProfile(rs.getInt("id"), 
            				rs.getInt("lipo"), rs.getInt("tri"), rs.getInt("rbc"), rs.getInt("glu"),
            				rs.getInt("vit"));
            		
            		profiles.add(profile);
            	}
    		
            }
            else{// if user does not exist in the HealUsers database
            	//create a new entry in the database
            	
            	//String insertuser = "INSERT INTO  `notes`.`users` (`id` , `email` , `password` )VALUES ( NULL , '" + username + "' ,  '" + password +"')";
            	//stmt.execute( insertuser );
            	
            	String insertuser = "INSERT INTO  `cs320stu02`.`HealUsers` (`id` , `email` , `password`, `name` )"
            						+ "VALUES ( NULL , '" + username + "' ,  '" + password + "' ,'" + "' '" + "')";
            	stmt.execute( insertuser );
            	
            	String query = "select id from HealUsers where name IS NULL";
            	ResultSet results = stmt.executeQuery(query);
            	results.last(); //move to recently inserted record
            	request.getSession().setAttribute("userId", results.getInt("id"));
            	
            	System.out.println("Creating new entry in HealUsers");

            }
    		
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        
        request.getSession().setAttribute("bloodProfiles", profiles);
        request.setAttribute("user", username);
//        request.getRequestDispatcher( "/WEB-INF/main.jsp" ).forward(
//            request, response );
        
        request.getRequestDispatcher("/MainController").forward(request,response);
        
    }

}
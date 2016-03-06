package model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Heal {

  Integer id;

  Date date;
  
  Integer owner;
  
  String title;
  
  String notes;

 
  public Heal()
  	{
  		}

  public Heal( Integer id, Integer owner, Date date, String title,   String notes)
  {
      this.id = id;
      this.owner = owner;
      this.date = new Date();
      this.title = title;
      this.notes = notes;
     
  }
  public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(date);
  }
  public Integer getId()
  {
      return id;
  }

  public void setId( Integer id )
  {
      this.id = id;
  }

  

  public String getTitle()
  {
      return title;
  }

  public void setTitle( String title )
  {
      this.title = title;
  }
  public String getNotes()
  {
      return notes;
  }

  public void setNotes( String notes )
  {
      this.notes = notes;
  }


 
}
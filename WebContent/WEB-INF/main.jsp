<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<div class = "container">
		<div class="page-header">
        	<h1>HEAL: Blood Check Analysis  <small>Welcome ${user }!</small></h1>        	
        </div>
        
        <div class = "row">
        	<div class="col-md-6">
     
      			<p class = "text-justify">
      				<strong>What would you like to do today ${user }</strong>
      			</p>
      		
  				<div class="dropdown">
    				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Menu Choices
    					<span class="caret"></span></button>
   					
   					 <ul class="dropdown-menu">
    					<li><a href="BloodCheckController">Blood Check</a></li>
      					<li><a href="DisplayController">User Profile</a></li>
       				</ul>
  				</div>
        	
        	</div>
        </div>
        
        <div class = "row">
        	<div class = "col-md-6">
        		<p class= "lead">${result }</p>
        	</div>
        </div>
      	

      	

      	
      	
      	<!--  
      		<c:if test = "${capture_start }">
     			<p class = "text-justify">
      				<strong>Capture starting, wait about three seconds before speaking</strong>
      			</p>
      		</c:if>
      	-->

      	
      	 

      

      	
      	<!--  
      	    <c:if test="${!validVoice }">
      			<p class = "text-justify">
      				<strong>Restarting the voice capture...</strong>
      			</p>
      		</c:if>
      	-->


	
	</div>
</body>
</html>
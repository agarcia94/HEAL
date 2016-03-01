<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class = "container">
		<div class="page-header">
        	<h1>HEAL: Blood Check Analysis  <small>Welcome ${username}!</small></h1>        	
        </div>
      	
      	<form action = "MainController" method = "post" class = "form-horizontal">
      		<p class = "text-justify">
      			<strong>Verbally state what you would like to do today ${username}</strong>
      		</p>
      		
      		<input type = "submit" value ="Start voice recognition" class = "btn btn-primary">
      	</form>
	</div>
</body>
</html>
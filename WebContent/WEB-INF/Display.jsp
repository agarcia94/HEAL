<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" 
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" 
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" 
	crossorigin="anonymous">


<title>HEAL - Display</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<ul class="nav nav-pills">
				<li><a class="navbar-brand" href="http://localhost:8080/HEAL/MainController">HEAL</a></li>
				<li class="active"><a href="http://localhost:8080/HEAL/DisplayController">Display</a></li>
				<li><a href="http://localhost:8080/HEAL/BloodCheckController">Blood Check</a></li>
				<li><a href="http://localhost:8080/HEAL/CommunicationController">Communication</a></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<p>Hello world</p>
		
		<form action="DisplayController" method="post">
			<input type="submit" class = "btn btn-primary">
		</form>
	</div>
</body>
</html>
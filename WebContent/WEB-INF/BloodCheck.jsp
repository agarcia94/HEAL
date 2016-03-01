<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!-- By Raymond Wu -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HEAL - Blood Check</title>

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


</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<ul class="nav nav-pills">
				<li><a class="navbar-brand" href="http://localhost:8080/Start/MainController">HEAL</a></li>
				<li><a href="http://localhost:8080/Start/DisplayController">Display</a></li>
				<li class="active"><a href="http://localhost:8080/Start/BloodCheckController">Blood Check</a></li>
				<li><a href="http://localhost:8080/Start/CommunicationController">Communication</a></li>
			</ul>
		</nav>
	</div>

	<div class="container">
		<div class="row">
			<form action = "BloodCheckController" method = "post" enctype = "multipart/form-data">
				<label for="blood_file">Attach blood sample</label>
				<input type = "file" name = "blood_file"> <br>
				<br>
				<input type = "submit" value ="Submit">
			</form>
		</div>
	</div>
</html>
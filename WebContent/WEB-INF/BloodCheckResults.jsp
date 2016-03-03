<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>HEAL - Blood Check Results</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<ul class="nav nav-pills">
				<li><a class="navbar-brand" href="http://localhost:8080/HEAL/MainController">HEAL</a></li>
				<li><a href="http://localhost:8080/HEAL/DisplayController">Display</a></li>
				<li><a href="http://localhost:8080/HEAL/BloodCheckController">Blood Check</a></li>
				<li class="active"><a href="http://localhost:8080/HEAL/CommunicationController">Communication</a></li>
			</ul>
		</nav>
	</div>

	<p>
	${current_profile.lipoproteins} <br/>
	${current_profile.triglycerides} <br/>
	${current_profile.bloodCells} <br/>
	${current_profile.glucose } <br/>
	${current_profile.vitamin } <br/>
	</p><br/>
	

	<a href = "DisplayController">Back to Portal</a>
</body>
</html>
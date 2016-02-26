<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Blood Check Results</title>
</head>
<body>
	<p>
	${current_profile.lipoproteins} <br/>
	${current_profile.triglycerides} <br/>
	${current_profile.bloodCells} <br/>
	${current_profile.glucose } <br/>
	${current_profile.vitamin } <br/>
	</p><br/>
	
	<center>
		<a href = "LoginController">Logout</a>
		<a href = "MainController">Back to Portal</a>
	</center>
</body>
</html>
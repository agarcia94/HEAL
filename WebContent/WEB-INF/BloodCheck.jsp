<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!-- By Raymond Wu -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blood Check Input</title>
</head>
<body>
	<center>

	<p> Please Attach Blood Sample <p>
	<form action = "BloodCheckController" method = "post" enctype = "multipart/form-data">
		<input type = "file" name = "blood_file"> <br>
		<br>
		<input type = "submit" value ="Submit">
	</form>
	</center><br/>

</body>

<body>
	<center>
		<a href = "MainController">Back</a><br/>                
		<a href = "LoginController">Logout</a>
	</center>
</body>


</html>
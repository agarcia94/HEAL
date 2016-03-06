<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>

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



<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HEAL - Communication</title>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<ul class="nav nav-pills">
				<li><a class="navbar-brand" href="MainController">HEAL</a></li>
				<li><a href="DisplayController">Display</a></li>
				<li><a href="BloodCheckController">Blood Check</a></li>
				<li class="active"><a href="CommunicationController">Communication</a></li>
			</ul>
		</nav>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<label for="emailAddress">To email your results, enter the email address here</label>				
				<form action="CommunicationController" method="post">
					<input type="text" value="Example@email.com" name="emailAddress"/>
					<input type="hidden" value="${emailMessage }" name="emailMessage"/>
					<input type="submit" value="Send email"/>
				</form>
				<h3>Your message:</h3>
				<p>${ emailMessage }</p>
			</div>
			<div class="col-md-6">
				<h3>Your results</h3>
				<table class="table">
					<c:forEach items="${ BloodStatResult.stats }" var="stat">
						<tr><th>${ stat.key }</th><td>${stat.value }</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<input type="text" name="angular-demo" ng-model="emailAddress2"/> <p> {{emailAddress2}} </p>
				<br/>
				<p> {{helloWorld}}
			</div>
			<div class="col-md-6">
			
			</div>
		</div>
	</div>
</body>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" 
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" 
	crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.min.js"></script>

</html>
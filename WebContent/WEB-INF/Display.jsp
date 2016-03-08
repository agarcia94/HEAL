
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
 
 
 
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
				<li><a class="navbar-brand" href="MainController">HEAL</a></li>
				<li class="active"><a href="DisplayController">Display</a></li>
				<li><a href="BloodCheckController">Blood Check</a></li>
				<li><a href="CommunicationController">Communication</a></li>
			</ul>
		</nav>
	</div>
	<div class="container">
		<p>${user} Blood check Results</p>
	</div>
	
	
 
  <div align="center">
        <table border="1" cellpadding="5">
            
            <tr>
                <th>Id</th>
                <th>Lipo</th>
                <th>Tri</th>
                <th>Rbc</th>
                <th>Glu</th>
                <th>vit</th>
           </tr>
            
            <c:forEach  items="${bloodProfiles}" var="profile">
                <tr>
                    <td><c:out value="${profile.userID}" /></td>
                    <td><c:out value="${profile.lipo}" /></td>
                    <td><c:out value="${profile.tri}" /></td>
                    <td><c:out value="${profile.rbc }"/></td>
                    <td><c:out value="${profile.glu }"/></td>
                    <td><c:out value="${profile.vit }"/></td>
                </tr>
            </c:forEach>

        </table>
    </div>
    
</body>


</html>
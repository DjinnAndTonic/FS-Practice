<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlets/JSP Project 2</title>
</head>
<body>
	<h1>Exercise 2</h1>
	<% if (request.getAttribute("error") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
	<form action="${pageContext.request.contextPath}/Exercise2Servlet" method="POST">	
		<table style="width:50%">
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" required></input></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required></input></td>
			</tr>
			<tr>
				<td><input type="submit" name="submitForm" value="Submit"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>
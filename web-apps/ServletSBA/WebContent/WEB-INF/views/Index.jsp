<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.time.format.DateTimeFormatter" %>  
<%@page import="java.time.LocalDateTime" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlets/JSP Project 1</title>
</head>
<body>
	<h1>Exercise 1</h1>
	<p>Hello! The current date and time is: 
	<%
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a");
		LocalDateTime now = LocalDateTime.now();
		
		String formattedLDT = now.format(dtf);
	%>
	<%= formattedLDT %>
	</p>
	<br />
	<p>
		<a href="${pageContext.request.contextPath}/Exercise2Servlet/Profile" >View/Edit Profile</a>
	</p>
</body>
</html>
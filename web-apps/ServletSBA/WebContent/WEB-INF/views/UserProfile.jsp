<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.perscholas.project02.UserDAO" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<h1>Profile</h1>
	<table>
		<tr>
			<td>User Id: </td>
			<td>${currentUser.userId}</td>
		</tr>
		
		<tr>
			<td>Username: </td>
			<td>${currentUser.username}</td>
		</tr>
		
		<tr>
			<td>Password: </td>
			<td>${currentUser.password}</td>
		</tr>
		
		<tr>
			<td><a href="${pageContext.request.contextPath}/Exercise2Servlet/Update">Edit</a></td>
		</tr>
	</table>
	<br />
	<p>
		<a href="${pageContext.request.contextPath}/Exercise2Servlet/Home" >Return</a>
	</p>
</body>
</html>
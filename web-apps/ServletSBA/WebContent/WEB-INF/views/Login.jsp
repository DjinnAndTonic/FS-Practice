<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
 <h1>Home Insurance Login</h1>
 	<% if (request.getAttribute("error") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
 	<form action="${pageContext.request.contextPath}/Exercise5Servlet/Welcome" method="POST">
 		<table>
 			<tr>
 				<td>Username: </td>
 				<td><input type="text" name="username" placeholder="username" required></input></td>
 			</tr>
 			
 			<tr>
 				<td>Password: </td>
 				<td><input type="password" name="password" placeholder="password" required></input></td>
 			</tr>
 			
 			<tr>
 				<td>
 					<a href="${pageContext.request.contextPath}/Exercise5Servlet/Register">Register</a>
 				</td>
 				<td><input type="submit" name="loginBtn" value="Login"></input></td>
 			</tr>
 		</table>
 	</form>
</body>
</html>
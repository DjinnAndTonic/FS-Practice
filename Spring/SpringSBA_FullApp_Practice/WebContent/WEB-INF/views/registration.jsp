<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<table>
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username" required></td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" required></td>
			</tr>
			
			<tr>
				<td>First Name: </td>
				<td><input type="text" name="fname" required></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="registerbtn"></td>
				<td><input type="reset"></td>
			</tr>
		</table>
	</form>
	
	<a href="${pageContext.request.contextPath}/login">Login Page</a>
</body>
</html>
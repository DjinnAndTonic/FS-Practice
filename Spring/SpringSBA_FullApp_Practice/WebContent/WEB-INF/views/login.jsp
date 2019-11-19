<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	<form action="${pageContext.request.contextPath}/home">
		<table>
			<tr>
				<td>Username: </td>
				<td><input type="text" required></td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td><input type="password" required></td>
			</tr>
			
			<tr>
				<td><input type="submit"></td>
				<td><input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>
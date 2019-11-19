<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="POST">
		<table>
			<tr>
				<td>Username: </td>
				<td><input type="text" name="username" placeholder="username" required/></td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" placeholder="password" required></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
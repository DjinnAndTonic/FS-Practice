<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/Exercise2Servlet/Profile" method="POST">
		<input type="hidden" name="currentUserId" value="1"></input>
		<table style="width:50%">
			<tr>
				<td>New Username:</td>
				<td><input type="text" name="newUsername" required></input></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="newPassword" required></input></td>
			</tr>
			<tr>
				<td><input type="submit" name="submitUpdate" value="Submit"></input></td>
			</tr>
		</table>	
	</form>
</body>
</html>
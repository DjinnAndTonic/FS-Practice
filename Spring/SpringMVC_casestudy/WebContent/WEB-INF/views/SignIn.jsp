<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>

<h1>Log in Page</h1>
	<fieldset>
		<legend>Log in</legend>
		<form:form action="${pageContext.request.contextPath}/verifyUser" method="post" modelAttribute="user">
			<div>
				<label for="username">User name:</label>
				<div>
					<form:input path="username"/>
					<p style="color:red;"><form:errors path="username" class="error"/></p>
				</div>
			</div>
			<div>
				<label for="password">Password: </label>
				<div>
					<form:input path="password"/>
					<p style="color:red;"><form:errors path="password" class="error"/></p>
				</div>
			</div>
			
			<input type="submit" value="Log In" />
		</form:form>
	</fieldset>

<a href="${pageContext.request.contextPath}/showRegisterPage">Register</a>

</body>
</html>




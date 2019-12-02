<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Register Page</h1>
	<form:form action="${pageContext.request.contextPath}/verifyRegister" 
	  method="post" modelAttribute="userDetail">
	  	<fieldset>
		<table>
			<tr>
				<td><label for="firstName">First Name: </label></td>
				<td><form:input type="text" path="firstName" required="required"/></td>
				<td><p style="color:red;"><form:errors path="firstName" class="error"/></p></td>
				
			</tr>
			
			<tr>
				<td><label for="middleName">Middle Name: </label></td>
				<td><form:input type="text" path="middleName"/></td>
			</tr>
			
			<tr>
				<td><label for="lastName">Last Name: </label></td>
				<td><form:input type="text" path="lastName" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="preferredName">Preferred Name: </label></td>
				<td><form:input type="text" path="preferredName" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="gender">Gender: </label></td>
				<td><form:input type="text" path="gender" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="genderPronoun">Gender Pronoun: </label></td>
				<td><form:input type="text" path="genderPronoun"/></td>
			</tr>
			
			<tr>
				<td><label for="email">Email: </label></td>
				<td><form:input type="text" path="email" required="required"/></td>
				<td><p style="color:red;"><form:errors path="email" class="error"/></p></td>
			</tr>
			
			<tr>
				<td><label for="address1">Address 1: </label></td>
				<td><form:input type="text" path="address1" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="address2">Address 2: </label></td>
				<td><form:input type="text" path="address2"/></td>
			</tr>
			
			<tr>
				<td><label for="city">City: </label></td>
				<td><form:input type="text" path="city" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="state">State: </label></td>
				<td><form:input type="text" path="state" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="zip">ZIP Code: </label></td>
				<td><form:input type="number" path="zip" maxlength="5" required="required"/></td>
			</tr>
			
<!-- 			<tr> -->
<!-- 				<td><label for="dob">Date: </label></td> -->
<%-- 				<td><form:input type="date" path="dob" required="required"/></td> --%>
<!-- 			</tr> -->
			
			<tr> 
				<td><input type="submit"></td>
				<td><input type="reset"></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/login">Login</a></td>
			</tr>
		</table>
		</fieldset>
	</form:form>
</body>
</html>
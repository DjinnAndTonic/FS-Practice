<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Form</title>
</head>
<body>
	<h1>Home Information</h1>
	<form action="${pageContext.request.contextPath}/Exercise5Servlet/Quote" method="POST">
		<table>
			<tr>
				<td>Address 1</td>
				<td><input type="text" name="addr1" required/></td>
			</tr>
			
			<tr>
				<td>Address 2</td>
				<td><input type="text" name="addr2" required/></td>
			</tr>
			
			<tr>
				<td>City</td>
				<td><input type="text" name="city" required/></td>
			</tr>
			
			<tr>
				<td>State</td>
				<td><input type="text" name="state" required  maxlength="2"/></td>
			</tr>
			
			<tr>
				<td>ZIP</td>
				<td><input type="number" name="zip" required maxlength="5"/></td>
			</tr>
			
			<tr>
				<td>Year Built</td>
				<td><input type="number" name="yearBuilt" required maxlength="4"/></td>
			</tr>
			
			<tr>
				<td>Home Value</td>
				<td><input type="number" name="value" step=".01" required/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" name="getQuoteBtn"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
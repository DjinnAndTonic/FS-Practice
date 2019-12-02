<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Frames</title>
</head>
<body>
	<header>
		<h1>Selenium Windows &amp; Frames Demonstration</h1>
		<h2>Frames Page</h2>
		<a href="${pageContext.request.contextPath}/HomeServlet">Back to Main Window Page</a>
	</header>
	<div>
		<iframe 
			name="frameOne" 
			id="if1" 
			src="${pageContext.request.contextPath}/HomeServlet/frameOne">Frame One</iframe>
		<iframe 
			name="frameTwo" 
			id="if2" 
			src="${pageContext.request.contextPath}/HomeServlet/frameTwo">Frame Two</iframe>
		<iframe 
			name="frameThree" 
			id="if3" 
			src="${pageContext.request.contextPath}/HomeServlet/frameThree">Frame Three</iframe>
	</div>
</body>
</html>
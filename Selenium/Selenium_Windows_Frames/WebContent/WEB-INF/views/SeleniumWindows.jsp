<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Window</title>
</head>
<body>
	<header>
		<h1>Selenium Windows &amp; Frames Demonstration</h1>
		<h2>Main Window</h2>
		<nav>
			<a href="javascript:void(0)" 
			onclick="window.open('${pageContext.request.contextPath}/HomeServlet/popUp', 'popUp', 'height=400px, width=400px, left=100px, top=200px')">Open Pop-up Window!</a>
		</nav>
	</header>
	<div>
		<a href="${pageContext.request.contextPath}/HomeServlet/frames">Frames Page</a>
	</div>
</body>
</html>
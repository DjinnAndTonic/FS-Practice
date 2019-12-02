<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium Wait Main Page</title>
</head>
<body>
 	<header></header>
 	<p>This page is designed to demonstrate the use of implicit and explicit waits
 	in Selenium. JavaScript is used to create the page title three seconds after 
 	the page is loaded. The test will throw an exception if no wait is utilized 
 	because the element does not exist for those initial three seconds. </p>
	<script>
		setTimeout(function(){  
			var pageTitle = document.createElement("h1");
			var node = document.createTextNode("Selenium Wait Demonstration Page");
			pageTitle.appendChild(node);
			pageTitle.setAttribute("id", "pageTitle");
			var element = document.getElementsByTagName("header")[0];
			element.insertBefore(pageTitle, element.childNodes[0]);
		}, 3000);
	</script>
</body>
</html>
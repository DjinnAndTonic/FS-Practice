<!-- The following page directive specifies the language, contentType and page
encoding as well as imports the Student class  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" import="com.perscholas.beans.Student"%>

<!DOCTYPE>
<html>
<head>
<title>Success Page</title>
<meta charset="ISO-8859-1">
</head>

<body>
	<%-- The following line assigns the request attribute "student" to a 
	Student object --%>	
	<% Student stu = (Student)request.getAttribute("student");
	
 	/*The following block of code uses the "include" directive to display a header 
 	that depends on the course selected by the user in the SignUp.jsp page*/
	if(stu.getCourse().equals("ASM")) { %>
		<h1>ASM</h1>
	<% } else if(stu.getCourse().equals("DE")) {%>
		<h1>DE</h1>
	<% } else if(stu.getCourse().equals("QEA")) {%>
		<h1>QEA</h1>
	<% } else {
		request.getRequestDispatcher("SignUp.jsp").forward(request, response);
	}
	%>
	<%-- The following line uses an expression tag to display the name of the student
	along with a welcome message. --%>
	<h2>Welcome, <%= stu.getName() %>! You signed up for <%= stu.getCourse() %>. Your password is '<%= stu.getPassword() %>'</h2>
</body>
</html>
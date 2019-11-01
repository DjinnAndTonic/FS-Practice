<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.time.*"%>  
<%@page import="java.time.temporal.ChronoUnit"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
	<% 	Cookie[] cookies = request.getCookies();
		String userName = "";
		String dob = "";
		
		for(Cookie c : cookies){
			if(c.getName().equals("dob")){
				dob = c.getValue();
			}
			if(c.getName().equals("username"))
				userName = c.getValue();
		}
		
		LocalDate born = LocalDate.parse(dob);
		LocalDate nextBDay = born.withYear(LocalDate.now().getYear());
		
		if(nextBDay.isBefore(LocalDate.now()) || nextBDay.isEqual(LocalDate.now()))
			nextBDay = nextBDay.plusYears(1);
		
		Period p = Period.between(LocalDate.now(), nextBDay);
		int months = p.getMonths();
// 		out.println("LD" + born);
	%>
</head>
<body>
	<h1>Welcome <%=userName %>! You have successfully logged in.</h1>
	<p>There are <%if(months > 0) out.print(months + " months and "); else out.print("");%> <%out.print(p.getDays() + " days until your birthday!"); %></p>
</body>
</html>
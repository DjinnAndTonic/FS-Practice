<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Log In</title>
</head>
<body>
    <form action="MyServlet" method="POST">
        Username:<br>
        <input type="text" name="username" id="username"><br>
        Password:<br>
        <input type="password" name="password" id="password"><br>
        <input type="submit" name="login" value="login"><br>
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
</head>
<body>
    <form action="./login.jsp" method="post">
        Username:<br>
        <input type="text" name="username"><br>
        Password:<br>
        <input type="password" name="password"><br>
        Confirm Password:<br>
        <input type="password" name="Confirm Password"><br>
        First Name:<br>
        <input type="text" name="firstName"><br>
        Last Name:<br>
        <input type="text" name="lastName"><br>
        Age:<br>
        <input type="number" name="age"><br>

        <input type="submit" name="submit"><br>
    </form>
</body>
</html>
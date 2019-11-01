<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">

function clearCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}

</script>


<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link href="${pageContext.request.contextPath}/css/formstyle.css" rel="stylesheet" type="text/css">
</head>

<body>
	<h1>Registration Page</h1>
	<form action="${pageContext.request.contextPath}/Login" id="registerform" method="post" onSubmit="checkPasswords(registerform)">
		<label>User Name:&nbsp;<input type="text" name="username" required></label>
		<br/>
		<label>Password:&nbsp;<input type="password" id="password" name="password" required/></label>
		<br/>
		<label>Confirm Password:&nbsp;<input type="password" name="password2" oninput='check(this)' required/></label>
		<script type='text/javascript'>
		    function check(input) {
		        if (input.value != document.getElementById('password').value) {
		            input.setCustomValidity('Password Must be Matching.');
		        } else {
		            // input is valid -- reset the error message
		            input.setCustomValidity('');
		        }
		    }
		</script>
		<br/>
		<label>First Name:&nbsp;<input type="text" name="fName" required/></label>
		<br/>
		<label>Last Name:&nbsp;<input type="text" name="lName" required/></label>
		<br/>
		<label>Date of Birth:&nbsp;<input type="date" name="dob" required/></label>
		<br/>
		<input type="submit" name="completeRegister" value="Register"/>
	</form>
<!-- 	 onSubmit="window.location.href='loginform.jsp'" -->
</body>
</html>


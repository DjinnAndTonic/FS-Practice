<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Home Insurance Registration</h1>
	<form action="${pageContext.request.contextPath}/Exercise5Servlet/Login" method="POST">
		<table>
			<tr>
				<td>
					First Name:
				</td>
				<td>
					<input type="text" name="fName" required />
				</td>
			</tr>
			
			<tr>
				<td>
					Last Name:
				</td>
				<td>
					<input type="text" name="lName" required />
				</td>
			</tr>
			
			<tr>
				<td>
					Date of Birth:
				</td>
				<td>
					<input type="date" name="dob" required />
				</td>
			</tr>
			
			<tr>
				<td>
					Email:
				</td>
				<td>
					<input type="text" name="email" required />
				</td>
			</tr>
			
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input type="password" id="password" name="password" required />
				</td>
			</tr>
			
			<tr>
				<td>
					Confirm Password:
				</td>
				<td>
					<input type="password" name="password2" oninput='check(this)' required />
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
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" name="registerBtn" value="Register"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
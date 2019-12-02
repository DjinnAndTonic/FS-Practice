<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Selenium Exercise CSS XPath</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style media="screen">
	.inner_div {
		display: inline-block;
	}
	
	.inner_div > h3, #row_two > h3, #row_three > h3 {
		padding: 15px;
	}
	
	.first_word {
		font-weight: bold;
	}
	
	div > p:nth-child(2) > span:not(:first-child) {
		color: orange;
	}
	
	div > p:last-child > span:not(:first-child) {
		color: red;
	}
	
	#one_right {
		border: 1px solid black;
		padding: 0px 10px;
	}
	
	#row_one > div {
		vertical-align: top;
	}
	
	body > div:last-of-type > a {
		text-decoration: none;
		padding: 10px;
	}
	table {
		border: 1px solid black;
		padding: 10px;
	}
</style>
<script>
	function formSubmit(formData) {
		var name = formData['name'].value;
		console.log(name);
		var email = formData['email'].value;
		var message = "Thank you " + name
				+ " for signing up! A welcome message will be sent to " + email
				+ ".";
		alert(message);
		document.querySelector("form").reset();
		document.querySelector("form > div> input[type = submit]").blur();
	}
</script>
</head>
<body>
	<header>
		<h1>Selenium Exercise CSS XPath</h1>
		<nav>
			<a href="javascript:alert('You clicked the Home button.');">Home</a>
			<a href="javascript:alert('You clicked the About Us button.');">About Us</a>
			<a href="javascript:alert('You clicked the Contact Us button.');">Contact Us</a>
		</nav>
	</header>
	<div class="outer_div" id="row_one">
		<h3>Row One</h3>
		<div id="one_left" class="inner_div">
			<table>
				<tr>
					<th rowspan=3>Colors</th>
					<td>red</td>
				</tr>
				<tr>
					<td>green</td>
				</tr>
				<tr>
					<td>blue</td>
				</tr>
				<tr>
					<th rowspan=3>Shapes</th>
					<td>circle</td>
				</tr>
				<tr>
					<td>triangle</td>
				</tr>
				<tr>
					<td>square</td>
				</tr>
				<tr>
					<th rowspan=3>Numbers</th>
					<td>one</td>
				</tr>
				<tr>
					<td>two</td>
				</tr>
				<tr>
					<td>three</td>
				</tr>
			</table>
		</div>
		<div id="one_right" class="inner_div">
			<p>Cities List</p>
			<ul>
				<li>Dallas</li>
				<li>New York</li>
				<li>Los Angeles</li>
			</ul>
			<p>State List</p>
			<ul>
				<li>Texas</li>
				<li>New York</li>
				<li>California</li>
			</ul>
		</div>
	</div>
	<div class="outer_div" id="row_two">
		<h3>Row Two</h3>
		<p>
			<span class="first_word">Vestibulum</span> ac diam sit amet quam vehicula elementum sed sit amet dui.
			Donec rutrum congue leo eget malesuada. <span>Per Scholas</span>
			pellentesque in ipsum id orci porta dapibus. Quisque velit nisi,
			pretium ut lacinia in, elementum id enim. <span>Dallas</span> mauris
			blandit aliquet elit, eget tincidunt nibh pulvinar a.
		</p>
		<p>
			<span class="first_word">Vivamus</span> magna justo, lacinia eget consectetur sed, convallis at
			tellus. Curabitur non nulla sit amet nisl tempus convallis quis ac
			lectus. Proin eget tortor risus. <span>Quality Engineering and
				Assurance</span> tortor risus. Pellentesque in ipsum id orci porta dapibus.
		</p>
	</div>
	<div class="outer_div" id="row_three">
		<h3>Row Three</h3>
		<p><span class="first_word">Vivamus</span> magna justo, 211 N Ervay St. Dallas, TX 75201, lacinia
			eget consectetur sed, convallis at tellus.</p>
		<p><span class="first_word">Curabitur</span> arcu erat, 5001 Statesman Dr. Ivring, TX 75063,
			accumsan id imperdiet et, porttitor at sem.</p>
		<p><span class="first_word">Mauris</span> blandit aliquet elit eget tincidunt nibh pulvinar a.
			Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.</p>
	</div>
	<fieldset>
		<legend>Signup for our newsletter!</legend>
		<form action="javascript:;" onsubmit="formSubmit(this);" method="post">
			<div>
				<label>Name</label> <input name="name" />
			</div>
			<div>
				<label>Email</label> <input name="email" />
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</form>
	</fieldset>
	<div>
		<ul>
			<li><a href="javascript:alert('You clicked the Corporate button.');">Corporate</a></li>
			<li><a href="javascript:alert('You clicked the Careers button.');">Careers</a></li>
			<li><a href="javascript:alert('You clicked the Customer Service button.');">Customer Service</a></li>
		</ul>
		<a href="https://facebook.com" class="fa fa-facebook" title="Facebook"></a>
		<a href="https://twitter.com" class="fa fa-twitter" title="Twitter"></a>
		<a href="https://google.com" class="fa fa-google" title="Google"></a>
	</div>
	<footer>Copyright &copy; 2019 by Me</footer>
</body>
</html>

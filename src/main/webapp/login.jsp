<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginPage</title>

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>
		body {
			background-color: #f2f2f2;
			font-family: Arial, sans-serif;
		}

		.container {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
		}

		form {
			display: inline-block;
			vertical-align: top;
			margin-right: 50px;
			padding: 20px;
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
		}

		h1 {
			margin-top: 0;
		}

		label {
			display: block;
			font-weight: bold;
			margin-bottom: 5px;
		}

		input[type="text"],
		input[type="password"],
		input[type="email"] {
			display: block;
			width: 100%;
			padding: 10px;
			border-radius: 5px;
			border: none;
			margin-bottom: 10px;
			box-sizing: border-box;
		}

		input[type="submit"] {
			background-color: #4CAF50;
			color: #fff;
			border: none;
			padding: 10px 20px;
			border-radius: 5px;
			cursor: pointer;
			font-size: 16px;
		}

		input[type="submit"]:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
<%--<div class="error">--%>
<%--	&lt;%&ndash; display error message if present &ndash;%&gt;--%>
<%--	<% if (request.getAttribute("errorMsg") != null) { %>--%>
<%--	<p style="color: red"><%= request.getAttribute("errorMsg") %></p>--%>
<%--	<% } %>--%>
<%--</div>--%>
<div style="text-align: center; margin: 0 auto;">
	<div class="error">
		<%-- display error message if present --%>
		<% if (request.getAttribute("errorMsg") != null) { %>
		<p style="color: red;"><%= request.getAttribute("errorMsg") %></p>
		<% } %>
	</div>
</div>
<div style="text-align: center; margin: 0 auto;">
	<div class="error">
		<%-- display error message if present --%>
		<% if (request.getAttribute("accDelete") != null) { %>
		<p style="color: forestgreen;"><%= request.getAttribute("accDelete") %></p>
		<% } %>
	</div>
</div>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color:#9EF9F6;">
	<a class="navbar-brand" href="#">CRM WEBSITE MADE BY -- ANIKET MOTE</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

		</ul>
	</div>
</nav>



<div class="container">
	<form action="userlogin">
		<h1>User Login</h1>
		<label for="userId">UserId:</label>
		<input type="text" id="userId" name="userId">



		<label for="upassword">Password:</label>
		<input type="password" id="upassword" name="upassword">

		<input type="submit" value="Submit">
	</form>

	<form action="login">
		<h1>Employee Login</h1>
		<label for="empId">Employee Id:</label>
		<input type="text" id="empId" name="empId">


		<label for="epassword">Employee Password:</label>
		<input type="password" id="epassword" name="epassword">

		<input type="submit" value="Submit">
	</form>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login here....</h1>
	<div>
		<%
		if (request.getAttribute("error") != null) {
			out.println(request.getAttribute("error"));
		}
		%>
	</div>
	<form action="verifyLogin" method="post">
		username<input type="text" name="user"> password<input
			type="password" name="pass"> <input type="submit"
			value="Login">
	</form>
</body>
</html>
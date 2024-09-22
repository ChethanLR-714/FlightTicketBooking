<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration...</title>
</head>
<body>
	<form action="update" method="post">
		<pre>
email<input type="text" name="email" value="<%=request.getAttribute("email") %>" />
mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile") %>"/>
<input type="submit" value="update" />
</pre>
	</form>
	<div>
		<%
		if (request.getAttribute("msg") != null) {
			out.println(request.getAttribute("msg"));
		}
		%>
	</div>
</body>
</html>

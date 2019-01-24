<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.accolite.app.model.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="alert alert-info  navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Accolite Sign In</a>
			</div>
			<ul class="nav">
				<li class="active"><a href="index.jsp"><button
							class="btn btn-success">Logout</button></a></li>
			</ul>
		</div>
	</nav>
	<table class="table" border="1">
		<tr>
			<td>Username</td>
			<td>City</td>
			<td>Email</td>
		</tr>
		<%
			ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
			for (User user : users) {
		%>
		<tr>
			<td><%=user.getUsername()%></td>
			<td><%=user.getCity()%></td>
			<td><%=user.getEmail()%></td>
		</tr>

		<%
			}
		%>
	</table>


</body>
</html>
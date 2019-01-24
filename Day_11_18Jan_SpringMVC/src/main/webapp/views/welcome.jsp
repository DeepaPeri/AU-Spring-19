<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<nav class="alert alert-info  navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Accolite Sign In</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a  href="index.jsp"><button class="btn btn-success">Logout</button></a></li>
		</ul>
	</div>
	</nav>
	
	<div class="alert alert-success">Welcome ${username}</div>


	<a href ="users">Users</a><br/>
	<a href ="edit">Edit User</a>
</body>
</html>
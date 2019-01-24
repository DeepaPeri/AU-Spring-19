<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
.center {
	width: 300px;
	height: 390px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	border: 1px solid #eeeeee;
	border-radius: 10px;
	padding: 20px;
}
</style>
</head>
<body>
	<nav class="alert alert-info navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">Accolite Sign In</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
			</ul>
		</div>
	</nav>
	<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<div class="center">
			<div>
				<form:label path="username">Username</form:label>
				<form:input class="form-control" path="username" name="username"
					id="username" />
			</div>
			<div>
				<form:label path="password">Password</form:label>
				<form:password class="form-control" path="password" name="password"
					id="password" />
			</div>
			<div>
				<form:label path="email">Email</form:label>
				<form:input class="form-control" path="email" name="email"
					id="email" />
			</div>
			<div>
				<form:label path="city">City</form:label>
				<form:input class="form-control" path="city" name="city" id="city" />
			</div>
			<br />
			<div>
				<form:button class="btn btn-success" id="register" name="register">Register</form:button>
			</div>
		</div>
	</form:form>
</body>
</html>
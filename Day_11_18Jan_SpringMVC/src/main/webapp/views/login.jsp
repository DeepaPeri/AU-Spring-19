<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.center {
	width: 300px;
	height: 340px;
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
	<nav class="alert alert-info navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Accolite Sign In</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="index.jsp">Home</a></li>
		</ul>
	</div>
	</nav>
	<form:form id="loginForm" modelAttribute="login" action="loginProcess"
		method="post">
		<div class="center">

			<div>
				<form:label path="username">Username: </form:label>
				<form:input class="form-control" path="username" name="username"
					id="username" />
			</div>

			<div>
				<form:label path="password">Password:</form:label>
				<form:password class="form-control" path="password" name="password"
					id="password" />
			</div>
			<br />
			<div>
				<form:button class="btn btn-success" id="login" name="login">Login</form:button>
			</div>
			<div style="font-color: red">${message}</div>
		</div>
	</form:form>

</body>
</html>
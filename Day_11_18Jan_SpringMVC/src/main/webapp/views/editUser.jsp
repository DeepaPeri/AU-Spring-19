<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.accolite.app.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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
	<%
		User user = (User) request.getAttribute("user");
	%>
	<div class="center">
		<form:form id="editForm" modelAttribute="user" action="editProcess"
			method="post">
			<div class="center">
				<div>
					<form:label path="username">Username</form:label>
					<form:input class="form-control" path="username" name="username"
						id="username" value="<%=user.getUsername()%>" />
				</div>
				<div>
					<form:label path="password">Password</form:label>
					<form:password class="form-control" path="password" name="password"
						id="password" value="<%=user.getPassword()%>" />
				</div>
				<div>
					<form:label path="email">Email</form:label>
					<form:input class="form-control" path="email" name="email"
						id="email" value="<%=user.getEmail()%>" />
				</div>
				<div>
					<form:label path="city">City</form:label>
					<form:input class="form-control" path="city" name="city" id="city"
						value="<%=user.getCity()%>" />
				</div>
				<br />
				<div>
					<form:button class="btn btn-success" id="register" name="register">Update</form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
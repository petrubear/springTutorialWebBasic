<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">

<title>Login</title>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Login</h3>

	<c:if test="${param.error !=null}">
		<div class="panel panel-danger">
			<!-- Default panel contents -->
			<div class="panel-heading">Error</div>
			<div class="panel-body">
				<p>Invalid Username & Password</p>
			</div>
		</div>
	</c:if>
	<form name='f'
		action='${pageContext.request.contextPath}/j_spring_security_check'
		method='POST' class="form form-horizontal" role="form">

		<div class="form-group">
			<div class="col-md-3">
				<label for="j_username">User</label> <input type='text'
					name='j_username' class="form-control" id='j_username' value=''
					placeholder="User" width="300">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-3">
				<label for="j_password">Password</label> <input type='password'
					name='j_password' class="form-control" id="j_password"
					placeholder="Password" width="300" />
			</div>
		</div>
		<input name="submit" type="submit" value="Login"
			class="btn btn-primary" /> 
			<!-- <a class="btn btn-primary"
            href="${pageContext.request.contextPath}/newaccount">View Offers</a> -->
            <a class="btn btn-primary"
            href="<c:url value="/newaccount"/>">New Account</a>
	</form>
</body>
</html>
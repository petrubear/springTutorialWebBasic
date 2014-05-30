<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>Authorized only!</h3>
			<table class="table table-striped table-bordered">
				<tr>
					<th>User</th>
					<th>Email</th>
					<th>Role</th>
					<th>Enabled</th>
				</tr>
				<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.username}"></c:out></td>
					<td><c:out value="${user.email}"></c:out></td>
					<td><c:out value="${user.authority}"></c:out></td>
					<td><c:out value="${user.enabled}"></c:out></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="row">
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
		</div>
	</div>
</body>
</html>
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
<title>Create Offer</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/docreate">
		<table class="table table table-striped table-bordered">
			<tr>
				<td>Name:</td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="email" type="text" /></td>
			</tr>
			<tr>
				<td>Offer:</td>
				<td><textarea name="text" rows="3" cols="40"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input class="btn btn-primary"
					value="Create" type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
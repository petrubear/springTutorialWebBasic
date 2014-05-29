<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		commandName="offer">
		<!-- command name es el nombre del model
		que recibe el metodo createOffer() en offerControler -->
		<table class="table table table-striped table-bordered">
			<tr>
				<td>Name:</td>
				<td><sf:input path="name" name="name" type="text" /> <br /> <sf:errors
						path="name"></sf:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input path="email" name="email" type="text" /> <br />

					<sf:errors path="email"></sf:errors></td>
			</tr>
			<tr>
				<td>Offer:</td>
				<td><sf:textarea path="text" name="text" rows="3" cols="40"></sf:textarea>
					<br /> <sf:errors path="text"></sf:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input class="btn btn-primary"
					value="Create" type="submit" />  <a class="btn btn-primary"
					href="${pageContext.request.contextPath}/">Home</a></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>
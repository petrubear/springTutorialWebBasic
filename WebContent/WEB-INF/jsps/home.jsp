<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Jsp</title>
</head>
<body>
	Hi There
	<p>
		<!-- usando session - no recomendado-->
		Session [no recomendado]:
		<%=session.getAttribute("name")%>
	</p>
	<p>
		<!-- usando request - no recomendado -->
		Request [no recomendado]:
		<%=request.getAttribute("name")%>
		<%-- request es un objeto interno --%>
	</p>
	<p>
		<!-- usando expression language -->
		Expression Language: ${name}
	</p>
	<p>
		<!-- usando jstl -->
		Jsp Standard Tag Library:
		<c:out value="${name}"></c:out>
	</p>

	<sql:query var="rs" dataSource="jdbc/spring">
        select id, name, email, text from offers
    </sql:query>
	<table class="table table-striped table-bordered">
		<tr>
			<th colspan="2">Offers</th>
		</tr>
		<c:forEach var="row" items="${rs.rows}">
			<tr class="info">
				<td>ID:</td>
				<td>${row.id}</td>
			</tr>
			<tr>
				<td>Name:</td>
				<td>${row.name}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${row.email}</td>
			</tr>
			<tr>
				<td>Text:</td>
				<td>${row.text}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
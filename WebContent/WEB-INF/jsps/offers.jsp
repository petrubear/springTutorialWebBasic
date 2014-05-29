<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Offers Home</title>
</head>
<body>
	<!-- 
    <table class="table table-striped table-bordered">
        <tr>
            <th colspan="2">Recibiendo Valores del Controller</th>
        </tr>
        <tr class="danger">
            <td>Session [no recomendado]:</td>
            <td><%=session.getAttribute("name")%></td>
        </tr>
        <tr class="danger">
            <td>Request [no recomendado]:</td>
            <td><%=request.getAttribute("name")%></td>
        </tr>
        <tr class="warning">
            <td>Expression Language:</td>
            <td>${name}</td>
        </tr>
        <tr class="success">
            <td>Jsp Standard Tag Library:</td>
            <td><c:out value="${name}"></c:out></td>
        </tr>
    </table>
    <sql:query var="rs" dataSource="jdbc/spring">
        select id, name, email, text from offers
    </sql:query>
    <table class="table table-striped table-bordered">
        <tr>
            <th colspan="2">MySQL Query (jstl-sql)</th>
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
    <p />
     -->
	<table class="table table-striped table-bordered">
		<tr>
			<th colspan="4">MySQL Query Dao - Service</th>
		</tr>
		<tr>
			<th class="info">ID:</th>
			<th>Name:</th>
			<th>Email:</th>
			<th>Text:</th>
		</tr>

		<c:forEach var="row" items="${offers}">
			<tr>
				<td class="info">${row.id}</td>
				<td>${row.name}</td>
				<td>${row.email}</td>
				<td>${row.text}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>
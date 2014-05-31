<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">

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
</div>

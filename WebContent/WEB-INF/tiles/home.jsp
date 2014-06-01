<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
				<td>${row.user.name}</td>
				<td>${row.user.email}</td>
				<td>${row.text}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<div class="row">
	<c:choose>
		<c:when test="${hasOffer}">
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/createoffer">Edit Offer</a>
		</c:when>
		<c:otherwise>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/createoffer">Create
				Offer</a>
		</c:otherwise>
	</c:choose>
	<p />
</div>
<div class="row">
	<a class="btn btn-primary"
		href="${pageContext.request.contextPath}/admin">Admin</a>
</div>
<p />


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="container">
	<h1>Offers Site</h1>
	<div class="row">
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/offers">View Offers</a> <a
			class="btn btn-primary"
			href="${pageContext.request.contextPath}/createoffer">Create
			Offer</a>
		<p />
	</div>
	<div class="row">
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin">Admin</a>
	</div>
	<p />
	<sec:authorize access="!isAuthenticated()">
		<div class="row">
			<a class="btn btn-primary" href="<c:url value='/login'></c:url>">Log
				in</a>
		</div>
		<p />
	</sec:authorize>


	<sec:authorize access="isAuthenticated()">
		<div class="row">
			<a class="btn btn-primary"
				href="<c:url value='/j_spring_security_logout'></c:url>">Log out</a>
		</div>
	</sec:authorize>
</div>

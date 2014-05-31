<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="!isAuthenticated()">
	<div class="row">
	<h1>Offers</h1>
		<a class="btn btn-primary" href="<c:url value='/login'></c:url>">Log
			in</a>
		<sec:authorize access="isAuthenticated()">
			<a class="btn btn-primary"
				href="<c:url value='/j_spring_security_logout'></c:url>">Log out</a>
		</sec:authorize>
	</div>
	<p />
</sec:authorize>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<h3>Login</h3>

	<c:if test="${param.error !=null}">
		<div class="panel panel-danger">
			<!-- Default panel contents -->
			<div class="panel-heading">Error</div>
			<div class="panel-body">
				<p>Invalid Username or Password</p>
			</div>
		</div>
	</c:if>
	<form name='f'
		action='${pageContext.request.contextPath}/j_spring_security_check'
		method='POST' class="form form-horizontal" >

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
		<div class="form-group">
			<div class="col-md-3">
				<label for="_spring_security_remember_me">Remember Me</label> <input
					type="checkbox" name='_spring_security_remember_me'
					class="form-control" id="_spring_security_remember_me"
					checked="checked" />
			</div>
		</div>
		<input name="submit" type="submit" value="Login"
			class="btn btn-primary" />
		<!-- <a class="btn btn-primary"
            href="${pageContext.request.contextPath}/newaccount">View Offers</a> -->
		<a class="btn btn-primary" href="<c:url value="/newaccount"/>">New
			Account</a>
	</form>
</div>

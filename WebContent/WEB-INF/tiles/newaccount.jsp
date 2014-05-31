<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirmpassword").keyup(checkPasswordMatch);
		//$("#accountform").submit(doSubmit);
	}

	function doSubmit() {
		if (password != confirmpassword) {
			event.preventDefault();
		} else {
			return;
		}
	}

	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmpassword = $("#confirmpassword").val();

		//if (password.length < 3 || confirmpassword.length < 3) return;

		$("#matchpass")
				.text(
						'<fmt:message key="PasswordMatch.password.match"></fmt:message>');
		$("#matchpass").removeClass("text-danger");
		$("#matchpass").addClass("text-success");
		if (password == confirmpassword) {
		} else {
			$("#matchpass")
					.text(
							'<fmt:message key="PasswordMatch.password.dontmatch"></fmt:message>');
			$("#matchpass").removeClass("text-success");
			$("#matchpass").addClass("text-danger");
		}
	}

	$(document).ready(onLoad);
</script>

<sf:form id="accountform" method="post"
	action="${pageContext.request.contextPath}/docreateaccount"
	commandName="user">
	<!-- command name es el nombre del model
        que recibe el metodo createOffer() en offerControler -->

	<div class="container">
		<div class="row">
			<table class="table table table-striped table-bordered">
				<tr>
					<td>Username:</td>
					<td><sf:input path="username" name="username" type="text" />
						<br /> <sf:errors path="username" cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><sf:input path="email" name="email" type="text" /> <br />
						<sf:errors path="email" cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><sf:input path="password" name="password" id="password"
							type="password" /> <br /> <sf:errors path="password"
							cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input name="confirmpassword" id="confirmpassword"
						type="password" />
						<div id="matchpass"></div></td>
				</tr>
				<tr>
					<td colspan="2" align="left"><input class="btn btn-primary"
						value="Create Account" type="submit" /> <a
						class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a></td>
				</tr>
			</table>
		</div>
	</div>
</sf:form>

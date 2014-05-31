<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form method="post"
	action="${pageContext.request.contextPath}/docreate"
	commandName="offer">
	<!-- command name es el nombre del model
		que recibe el metodo createOffer() en offerControler -->

	<div class="container">
		<div class="row">
			<table class="table table table-striped table-bordered">
				<tr>
					<td>Name:</td>
					<td><sf:input path="name" name="name" type="text" /> <br />
						<sf:errors path="name" cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><sf:input path="email" name="email" type="text" /> <br />
						<sf:errors path="email" cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td>Offer:</td>
					<td><sf:textarea path="text" name="text" rows="3" cols="40"></sf:textarea>
						<br /> <sf:errors path="text" cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td colspan="2" align="left"><input class="btn btn-primary"
						value="Create" type="submit" /></td>
				</tr>
			</table>
		</div>
	</div>
</sf:form>

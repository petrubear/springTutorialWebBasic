<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form method="post"
	action="${pageContext.request.contextPath}/docreate"
	commandName="offer">
	<!-- command name es el nombre del model
		que recibe el metodo createOffer() en offerControler -->

	<sf:input name="id" type="hidden" path="id" />
	<div class="container">
		<div class="row">
			<table class="table table table-striped table-bordered">
				<tr>
					<td>Offer:</td>
					<td><sf:textarea path="text" name="text" rows="3" cols="40"></sf:textarea>
						<br /> <sf:errors path="text" cssClass="text-danger"></sf:errors></td>
				</tr>
				<tr>
					<td colspan="2" align="left"><input class="btn btn-primary"
						value="Save Offer" type="submit" /></td>
				</tr>
			</table>
		</div>
	</div>
</sf:form>

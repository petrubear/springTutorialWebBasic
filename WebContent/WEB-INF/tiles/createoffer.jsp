<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function onDeleteClick(event) {
		var doDelete = confirm("Do you want to delete this offer?");
		if (doDelete == false) {
			event.preventDefault();
		}
	}

	function onLoad() {
		$("#delete").click(onDeleteClick);
	}
	$(document).ready(onLoad);
</script>
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
				<c:if test="${offer.id != 0}">
					<tr>
						<td colspan="2" align="left"><input class="btn btn-danger"
							value="Delete Offer" type="submit" name="delete" id="delete" /></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</sf:form>

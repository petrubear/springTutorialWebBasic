<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-danger">
				<!-- Default panel contents -->
				<div class="panel-heading">An error has occurred.</div>
				<div class="panel-body">
					<p>${description}</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
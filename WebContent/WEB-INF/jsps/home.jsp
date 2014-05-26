<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Jsp</title>
</head>
<body>
	Hi There
	<p>
		<!-- usando session - no recomendado-->
		Session [no recomendado]:
		<%=session.getAttribute("name")%>
	</p>
	<p>
		<!-- usando request - no recomendado -->
		Request [no recomendado]:
		<%=request.getAttribute("name")%>
		<%-- request es un objeto interno --%>
	</p>
	<p>
		<!-- usando expression language -->
		Expression Language: ${name}
	</p>
	<p>
		<!-- usando jstl -->
		Jsp Standard Tag Library: <c:out value="${name}"></c:out>
	</p>
</body>
</html>
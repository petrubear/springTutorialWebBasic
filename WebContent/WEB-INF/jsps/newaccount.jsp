<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- bootstrap CSS -->
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Account</title>
</head>
<body>
    <sf:form method="post"
        action="${pageContext.request.contextPath}/docreateaccount"
        commandName="user">
        <!-- command name es el nombre del model
        que recibe el metodo createOffer() en offerControler -->
        <table class="table table table-striped table-bordered">
            <tr>
                <td>Username:</td>
                <td><sf:input path="username" name="username" type="text" /> <br />
                    <sf:errors path="username"></sf:errors></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><sf:input path="email" name="email" type="text" /> <br />
                    <sf:errors path="email"></sf:errors></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><sf:input path="password" name="password" type="text" /> <br />
                    <sf:errors path="password"></sf:errors></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input name="confirmpassword" type="text" /></td>
            </tr>
            <tr>
                <td colspan="2" align="left"><input class="btn btn-primary"
                    value="Create Account" type="submit" /> <a class="btn btn-primary"
                    href="${pageContext.request.contextPath}/">Back</a></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
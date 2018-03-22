  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="register" method="post" commandName="customer">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2> Registration New User</h2></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="customerName" /></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><form:input path="customerEmail" /></td>
                </tr>
                <tr>
                    <td>Phone No.:</td>
                    <td><form:input path="customerPhone" /></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>

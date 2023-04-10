<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<a href="../user/sign-in">Sign in</a>
<h1>Sign Up</h1>
<form:form method="post" action="sign-up" modelAttribute="user">
    <table >
        <tr>
            <td>Email: </td>
            <td><form:input path="email" type="email" required="required"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><form:input path="password" type="password" required="required"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Sign Up"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

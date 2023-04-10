<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Vehicle Index</title>
</head>
<body>
<a href="../incident/index">Incident</a>
<a href="../user/sign-out">Sign out</a>
<h1>Vehicle Index</h1>
<form:form method="post" modelAttribute="vehicle">
    <table>
        <tr>
            <td>Plate number</td>
            <td><form:input path="plateNumber" required="required"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><form:input path="description" required="required"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form:form>
<h1>Vehicles</h1>
<table border="">
    <tr>
        <th>Id</th>
        <th>Plate number</th>
        <th>Description</th>
        <th></th>
    </tr>
    <c:forEach items="${vehicles}" var="vehicle">
        <tr>
            <td>${vehicle.id}</td>
            <td>${vehicle.plateNumber}</td>
            <td>${vehicle.description}</td>
            <td><a href="${vehicle.id}/delete">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

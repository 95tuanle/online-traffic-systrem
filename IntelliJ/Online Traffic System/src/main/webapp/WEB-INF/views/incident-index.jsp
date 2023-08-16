<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Incident Index</title>
</head>
<body>
<a href="../vehicle/index">Vehicle</a>
<a href="../user/sign-out">Sign out</a>
<h1>Incident Index</h1>
<form:form modelAttribute="incident" method="post">
    <table>
        <tr>
            <td>Vehicle</td>
            <td>
                <form:select path="vehicle.id" required="required">
                    <form:option value="">-- Select --</form:option>
                    <form:options items="${vehicles}" itemValue="id" itemLabel="plateNumber"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Date time</td>
            <td>
                <form:input path="dateTime" required="required" type="datetime-local"/>
            </td>
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
<table border="">
    <tr>
        <th>Id</th>
        <th>Vehicle</th>
        <th>Date time</th>
        <th>Description</th>
        <th></th>
    </tr>
    <c:forEach items="${incidents}" var="incident">
    <tr>
        <td>${incident.id}</td>
        <td>${incident.vehicle.plateNumber}</td>
        <td>${incident.dateTime}</td>
        <td>${incident.description}</td>
        <td><a href="${incident.id}/delete">Delete</a></td>
    </tr>
    </c:forEach>
</body>
</html>

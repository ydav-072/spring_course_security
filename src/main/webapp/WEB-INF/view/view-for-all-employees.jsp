<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Information for all Employees</h2>
    <br><br>
    <security:authorize access="hasRole('HR')">
        <input type="button" value="Salary" onclick="window.location.href = 'hr-info'">
        Only for HR staff
    </security:authorize>
    <br><br>
    <security:authorize access="hasRole('MANAGER')">
        <input type="button" value="Performance" onclick="window.location.href = 'manager-info'">
        Only for MANAGERS
    </security:authorize>
</body>
</html>

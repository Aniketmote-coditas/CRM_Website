<%--
  Created by IntelliJ IDEA.
  User: coditas
  Date: 30-04-2023
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EmployeeEditForm</title>
</head>
<body>
<h1>Employee Edit Form</h1>
<form action="save" method="get">
<c:forEach var="crm" items="${crmList}">
    <label for="empId">Employee Id:</label>
    <input type="text" id="empId" name="empId" value="<c:out value="${crm.empid}" />"><br><br>
    <label for="empName">Employee Name:</label>
    <input type="text" id="empName" name="empName" value="<c:out value="${crm.name}" />"><br><br>
    <label for="empEmail">Employee Email:</label>
    <input type="text" id="empEmail" name="empEmail" value="<c:out value="${crm.email}" />"><br><br>
    <label for="empPassword">Employee password:</label>
    <input type="text" id="empPassword" name="empPassword" value="<c:out value="${crm.password}" />"><br><br>
    <label for="empCity">Employee City:</label>
    <input type="text" id="empCity" name="empCity" value="<c:out value="${crm.city}" />"><br><br>
    <input type="submit" value="Save">
</c:forEach>
    <a href="showAllEmployee">back</a>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: coditas
  Date: 01-05-2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Edit Form</title>
</head>
<body>
<h1>Customer Edit Form</h1>
<form action="saveCustomer" method="get">
  <c:forEach var="crm" items="${crmList}">
    <label for="empId">Customer Id:</label>
    <input type="text" id="empId" name="empId" value="<c:out value="${crm.customerId}" />"><br><br>
    <label for="empName">Customer Name:</label>
    <input type="text" id="empName" name="empName" value="<c:out value="${crm.customername}" />"><br><br>
    <label for="empEmail">Customer Email:</label>
    <input type="text" id="empEmail" name="empEmail" value="<c:out value="${crm.customeremail}" />"><br><br>
    <label for="empPassword">Customer password:</label>
    <input type="text" id="empPassword" name="empPassword" value="<c:out value="${crm.customerpassword}" />"><br><br>
    <label for="empCity">Customer City:</label>
    <input type="text" id="empCity" name="empCity" value="<c:out value="${crm.customercity}" />"><br><br>
    <input type="submit" value="Save">
  </c:forEach>
  <a href="showAllEmployee">back</a>
</form>
</body>
</html>

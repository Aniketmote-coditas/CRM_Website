<%--
  Created by IntelliJ IDEA.
  User: coditas
  Date: 02-05-2023
  Time: 07:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Issues Edit Form</title>

    <style>
        body {
            height: 100vh;
            background-color: #f1f1f1;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
        form {
            width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            border-radius: 5px;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"], textarea {
            display: block;
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            margin-bottom: 20px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <div style="text-align: center;">
        <div class="error">
            <%-- display error message if present --%>
            <% if (request.getAttribute("addissue") != null) { %>
            <p style="color: forestgreen;"><%= request.getAttribute("addissue") %></p>
            <% } %>
        </div>
        <form action="editissue">
            <c:forEach var="crm" items="${crmList}">
            <label for="issue-Id">Issue Id:</label>
            <input type="text" name="issue-Id" id="issue-Id" value="<c:out value="${crm.issue_id}"/>" readonly><br><br>

            <label for="issue-name">Issue Name:</label>
            <input type="text" name="issue-name" id="issue-name" value="<c:out value="${crm.issue_Name}"/>"><br><br>

            <label for="issue-desc">Description:</label>
            <textarea name="issue-desc" id="issue-desc" rows="7" value="<c:out value="${crm.description}"/>"></textarea>

            <input type="submit" value="save">
            </c:forEach>
        </form>
        <a href="showIssues"><button class="btn btn-primary btn-md" style="background-color: blue; color: white; font-size: 16px;display: block; margin: 0 auto;">Back</button></a>

    </div>
</div>

</body>
</html>

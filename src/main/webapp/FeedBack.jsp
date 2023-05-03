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
    <title>FeedBack Form</title>

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
            <% if (request.getAttribute("s") != null) { %>
            <p style="color: forestgreen;"><%= request.getAttribute("s") %></p>
            <% } %>
        </div>
        <form action="FeedBack">
            <label for="crm-name">Name Of CRM:</label>
            <input type="text" name="crm-name" id="crm-name" >

            <label for="feedback-desc">FeedBack:</label>
            <textarea name="feedback-desc" id="feedback-desc" rows="6"></textarea>

            <input type="submit" value="Submit FeedBack">
        </form>
        <a href="CustomerPanel.jsp"><button class="btn btn-primary btn-md" style="background-color: blue; color: white; font-size: 16px;display: block; margin: 0 auto;">Back</button></a>

    </div>
</div>

</body>
</html>

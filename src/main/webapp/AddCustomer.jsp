<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <meta charset="UTF-8">
  <title>Customer Registration Form</title>
  <style>
    body {
      background-color: white;
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    h1 {
      color: #333;
      font-size: 36px;
      margin: 30px;
      text-align: center;
    }
    form {
      display: flex;
      flex-direction: column;
      align-items: center;
      margin-top: 30px;
    }
    input[type="submit"] {
      background-color: #007bff;
      border: none;
      border-radius: 5px;
      color: #fff;
      cursor: pointer;
      font-size: 18px;
      padding: 10px 20px;
      margin-top: 20px;
    }
    input[type="submit"]:hover {
      background-color: #0062cc;
    }
  </style>

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: #9EF9F6">
  <div>
    <h3>Registration</h3>
  </div>
</nav>
<%
  // get the session object
  HttpSession sessions = request.getSession(false); // do not create a new session if one doesn't exist
  int userId=0;
  // check if the user is logged in
  if (sessions != null && sessions.getAttribute("empId") != null) {
    // get the user's id from the session object
    userId = (int) sessions.getAttribute("empId");
  } else {
    response.sendRedirect("login.jsp");
  }
%>
<h1><%=userId%></h1>
<h1>Customer Registration Form</h1>
<form action="s" method="get">
  <label for="cName">Enter Name:</label>
  <input type="text" id="cName" name="cName"><br><br>
  <label for="cEmail">Enter Email:</label>
  <input type="text" id="cEmail" name="cEmail"><br><br>
  <label for="cPassword">Enter password:</label>
  <input type="text" id="cPassword" name="cPassword"><br><br>
  <label for="cCity">Enter City:</label>
  <input type="text" id="cCity" name="cCity"><br><br>
  <input type="submit" value="Register The Customer">
  <a href="EmployeePanel.jsp">back</a>
</form>

</body>
</html>

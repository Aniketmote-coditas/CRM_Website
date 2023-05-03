<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <title>Employee Registration Form</title>
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
      margin-top: 5px;
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
<h1>Employee Registration Form</h1>
<form action="addEmployee" method="get">
  <label for="empName">Enter Name:</label>
  <input type="text" id="empName" name="empName"><br><br>
  <label for="empEmail">Enter Email:</label>
  <input type="text" id="empEmail" name="empEmail"><br><br>
  <label for="empPassword">Enter password:</label>
  <input type="text" id="empPassword" name="empPassword"><br><br>
  <label for="empCity">Enter City:</label>
  <input type="text" id="empCity" name="empCity"><br><br>
  <input type="submit" value="Submit">

  <a href="adminpanel.jsp">back</a>
</form>

</body>
</html>

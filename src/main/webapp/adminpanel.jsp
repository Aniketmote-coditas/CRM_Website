<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Panel</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: #9EF9F6">
    <div>
      <h3>Admin Panel</h3>
    </div>



  </nav>
</header>
<h1></h1>
<form action="AddEmployee.jsp" method="get">
  <input type="submit" value="Add Employee">
</form>
<form action="showAllEmployee" method="get">
  <input type="submit" value="Show All Employee">
</form>
<form action="showAllCustomer" method="get">
  <input type="submit" value="Show All Customer">
</form>
<form action="showAllIssues" method="get">
  <input type="submit" value="Show All Issues">
</form>
<form action="showAllFeedback" method="get">
  <input type="submit" value="Show All Feedback By Customer">
</form>
<form action="logout" method="get">
  <input type="submit" style="background: red" value="Logout">
</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Rpipc
  Date: 2/2/2021
  Time: 12:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">

    <br><br><br><br><h1><p>Wrong Id or password</h1><br>
<form action="servlet2" method="post">
    firstname :<input type="text" name="firstName" required><br><br>
    lastname  :<input type="text" name="lastName" required><br><br>
    email     :<input type="email" name="email" required><br><br>
    username  :<input type="text" name="userName" required><br><br>
    password  :<input type="password" name="password" required><br><br>
    <input type="submit" value="login">
</form>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
<br><br><br><br><br><br>
<div style="text-align: center;"><h2><p>Enter your login<p></h2>
    <%session.setAttribute("username" ,session.getAttribute("username"));%>
<form method="get" action="save">
    FirstName :<input type="text" name="firstname"><br><br>
    LastName : <input type="text" name="lastName"><br><br>
    userName : <input type="text" name="username"><br><br>
    Email :    <input type="text" name="email"><br><br>
    <input type="submit" value="save"><br><br>
</form>
    <form method="get" action="viewAll">
        <input type="submit" value="loadAll">
    </form>

</div>

</body>
</html>

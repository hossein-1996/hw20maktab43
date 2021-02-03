<%@ page import="entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center;"><h2><p>Enter your login<p></h2>

    <form method="get" action="saveUpdate">
        <%Employee employee = (Employee) request.getAttribute("employee");%>
        <br><br><br><br><br><br>
        <input type="hidden" name="id" value="<%=employee.getId()%>">
        FirstName : <%=employee.getfirstName()%><br>
        <input type="text" name="firstname"><br><br>
        LastName  : <%=employee.getLastName()%><br>
        <input type="text" name="lastName"><br><br>
        userName  : <%=employee.getUserName()%><br>
        <input type="text" name="username"><br><br>
        Email     : <%=employee.getEmail()%><br>
        <input type="text" name="email"><br><br>
        <input type="submit" value="save"><br><br>
    </form>


</div>
</body>
</html>

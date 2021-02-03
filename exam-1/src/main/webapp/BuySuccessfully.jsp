<%--
  Created by IntelliJ IDEA.
  User: Rpipc
  Date: 2/1/2021
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <br><br><br><br><br><br><br><br><br>
    <h1><p><%=session.getAttribute("gender")%> <%=session.getAttribute("fullname")%> , the ticket purchase operation has been completed successfully for you.</p></h1><br><br>
    <h2><p><a href="index.jsp">Click</a> here go to first page</p></h2>

</div>
</body>
</html>

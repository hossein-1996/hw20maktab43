<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br><br><br>
<div style="text-align: center;">
<h1><p>select your operation</p></h1>
<%String username = (String) request.getAttribute("username");%>
<h3><p>welcome to <%=username%></p></h3>
<br><br>
        <form method="get">
        <h3><p>buy ticket</p></h3>
        <a href="tickets.jsp?username=<%=username%>">buy</a>
        </form>
        <form  method="get">
        <h3><p>View all purchased tickets </p></h3>
        <%session.setAttribute("username",username);%>
        <a href="ticketbuyed?username=<%=username%>">show</a>
        </form>
</div>
</body>
</html>

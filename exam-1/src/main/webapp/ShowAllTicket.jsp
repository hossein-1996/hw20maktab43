<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><p align ="center">Your previous booking</p></h1><br><br>
<div align="center">
    <form action="${pageContext.request.contextPath}/" method="post">
        <left></left>

        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>date</th>
                <th>select</th>
            </tr>
            <c:forEach var="ticket" items="${ticketlist}">
                <tr>
                    <td><c:out value="${ticket.id}" /></td>
                    <td><c:out value="${ticket.dateOfDeparture}" /></td>
                    <td>
                      <a href="show?id=${ticket.id}">show</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>

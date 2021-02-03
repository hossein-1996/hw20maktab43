<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><p align ="center">Your previous booking</p></h1><br><br>
<div align="center">
    <form  method="post">
        <left></left>

        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>fullname</th>
                <th>gender</th>
                <th>beginning</th>
                <th>Destination</th>
                <th>DateOfDeparture</th>
                <th>HourOfDeparture</th>
                <th>direction_id</th>
                <th>select</th>
            </tr>
            <c:forEach var="tickets" items="${ticket}">
                <tr>
                    <td><c:out value="${tickets.id}" /></td>
                    <td><c:out value="${tickets.name}" /></td>
                    <td><c:out value="${tickets.gender}" /></td>
                    <td><c:out value="${tickets.beginning}" /></td>
                    <td><c:out value="${tickets.Destination}" /></td>
                    <td><c:out value="${tickets.dateOfDeparture}" /></td>
                    <td><c:out value="${tickets.HourOfDeparture}" /></td>
<%--&lt;%&ndash;                    <td><c:out value="${tickets.direction_id}" /></td>&ndash;%&gt;--%>
<%--                    <td>--%>
<%--                            &lt;%&ndash;                    <a href="name.jsp">Select</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <a href="show.jsp?id=${tickets.id}">show</a>&ndash;%&gt;--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>

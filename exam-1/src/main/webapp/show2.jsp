<%@ page import="entity.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: Rpipc
  Date: 2/1/2021
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><p align ="center">Your previous booking</p></h1><br><br>
<div align="center">
    <%Ticket ticket = (Ticket) request.getAttribute("ticket");%>
    <form action="${pageContext.request.contextPath}/" method="post">
        <left></left>

        <table border="1" cellpadding="5">
            <caption><h2>List of Tickets</h2></caption>
            <tr>
                <th>ID</th>
                <th>fullname</th>
                <th>gender</th>
                <th>beginning</th>
                <th>Destination</th>
                <th>DateOfDeparture</th>
                <th>HourOfDeparture</th>
                <th>travel id</th>
                <th>select</th>
            </tr>
            <%
                for (int i = 1; i<2; i++) {
            %>
            <tr>
                <td><%=ticket.getId()%></td>
                <td><%=ticket.getName()%></td>
                <td><%=ticket.getGender()%></td>
                <td><%=ticket.getBeginning()%></td>
                <td><%=ticket.getDestination()%></td>
                <td><%=ticket.getDateOfDeparture()%></td>
                <td><%=ticket.getHourOfDeparture()%></td>
                <td><%=ticket.getDirection().getId()%></td>
               <td><a href="cancel?id=${ticket.id}">Cancel tickets</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </form>
</div>
</body>
</html>

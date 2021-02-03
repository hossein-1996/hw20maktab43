<%@ page import="entity.Direction" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Previous Bookings
</title>
</head>
<body>
<h1><p align ="center">Your previous booking</p></h1><br><br>
<div align="center">
    <form action="servlet4" method="post">
        <%String userName = (String) session.getAttribute("username");
        session.setAttribute("username",userName);%>
        <input type="hidden" name="value" value="directions" />
        <h3><p> <%=userName%> </p></h3>
<%--        <input type="hidden" name="username" value="<%=userName%>">--%>
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>hourOfDeparture</th>
            <th>select</th>
        </tr>
            <c:forEach var="user" items="${directions}">

            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.hourOfDeparture}" /></td>
                <td>
                 <a href="name.jsp?id=${user.id}">buy</a>
<%--                   <input type="submit" value="buy" />--%>
                </td>
            </tr>
    </c:forEach>
    </table>
    </form>
</div>

</body>
</html>
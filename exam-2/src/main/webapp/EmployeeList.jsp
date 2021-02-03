<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><p align ="center">Your previous booking</p></h1><br><br>
<div align="center">
    <form action="/" method="get">

        <%--        <input type="hidden" name="username" value="<%=userName%>">--%>
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>firstname</th>
                <th>lastname</th>
                <th>username</th>
                <th>email</th>
                <th>delete</th>
                <th>update</th>
                <th>Specifications</th>
            </tr>
            <c:forEach var="employee" items="${employeeList}">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.firstName}" /></td>
                    <td><c:out value="${employee.lastName}" /></td>
                    <td><c:out value="${employee.userName}" /></td>
                    <td><c:out value="${employee.email}" /></td>
                    <td>
                        <a href="delete?id=${employee.id}">delete</a>
                    </td>
                    <td>
                        <a href="update?id=${employee.id}">Edit</a>
                    </td>
                    <td>
                        <a href="showDetails?id=${employee.id}">showDetails</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>

</body>
</html>

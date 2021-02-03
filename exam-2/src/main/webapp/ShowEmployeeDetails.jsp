<%@ page import="entity.EmployeeDetails" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rpipc
  Date: 2/3/2021
  Time: 11:11 PM
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
    <form action="/" method="get">
        <%EmployeeDetails employeeDetails = (EmployeeDetails) request.getAttribute("employeeDetails");%>
        <%--        <input type="hidden" name="username" value="<%=userName%>">--%>
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>fatherName</th>
                <th>nationalCode</th>
                <th>address</th>
                <th>idNumber</th>
                <th>employee</th>
            </tr>
                <tr>
                    <td><c:out value="<%=employeeDetails.getId()%>" /></td>
                    <td><c:out value="<%=employeeDetails.getFatherName()%>" /></td>
                    <td><c:out value="<%=employeeDetails.getNationalCode()%>" /></td>
                    <td><c:out value="<%=employeeDetails.getAddress()%>" /></td>
                    <td><c:out value="<%=employeeDetails.getIdNumber()%>" /></td>
                    <td><c:out value="<%=employeeDetails.getEmployee().getId()%>" /></td>
                </tr>
        </table>
        <br><br><br>
        <a href="index.jsp" >first page</a>
    </form>
</div>

</body>
</html>

<%@ page import="entity.Direction" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><p align="Center">select your direction</p></h1>
<br><br><br><br>
<div style="text-align: center;">
    <form action="buy" method="get">
        <%String userName = (String) session.getAttribute("username");
        session.setAttribute("username",userName);%>
        <% Integer id=Integer.parseInt(request.getParameter("id"));%>
        <h3><p> <%=userName%> </p></h3>
    <h3><p> Enter Your full Name </p></h3>
    <input type="text" name="fullName" value=""><br><br>
        <h3><p> Enter your Gender </p></h3>
    <select name="selectBox" >
        <option value="male">male</option>
        <option value="female">female</option>
    </select><br><br>
        <input type="hidden" name="id" value="<%=id%>">
<%--        <a href="buy">OK</a>--%>
        <input type="submit"  value="OK">
    </form>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Rpipc
  Date: 2/3/2021
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br><br><br><br><br>
<div style="text-align: center;"><h2><p>You have not entered your details<p></h2>
    <%Integer id = (Integer) request.getAttribute("id");%>
    <form method="get" action="saveDetails">
        <input type="hidden" name="id" value="<%=id%>">
        fatherName :   <input type="text" name="fatherName"><br><br>
        nationalCode : <input type="text" name="nationalCode"><br><br>
        address :      <input type="text" name="address"><br><br>
        idNumber :     <input type="text" name="idNumber"><br><br>
        <input type="submit" value="save"><br><br>
    </form>
</div>

</body>
</html>

<html dir="rtl">

<head >
	<meta charset=utf-8">
<title>Tickets Booking</title>
</head>
<body>
<h1><p align="Center">select your direction</p></h1>
<br><br><br><br>
<div style="text-align: center;">
<form action="servlet3" method="POST">
	<%String userName =request.getParameter("username");
	session.setAttribute("username",userName);%>
	<h3><p> <%=userName%> </p></h3>
	  <h3><p> beginning </p></h3>
      <input type="text" name="beginning" value=""><br>
	  <h3> <p> Destination </p></h3>
	  <input type="text" name="Destination" value=""><br>
	  <h3><p dir="rtl"> Date of departure </p></h3>
	  <input type="text" name="tarikh" value=""><br>
	  <br><br>
<%--	  <input type="hidden" name="username" value="<%=userName%>">--%>
      <input type="submit" value="Submit" />
      </form>
	  </div>

</body>
</html>
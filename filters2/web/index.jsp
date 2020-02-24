<%-- In this lesson i learn hotw to use filters in web app

24.02.2020

--%>



<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-22
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Strona glowna</title>
  </head>
  <body>
    <h1>Witaj,  Twoje Ip to:</h1>
      <h2>Ip: <%=request.getRemoteAddr()%></h2>
  <a href="admin.jsp">Logowanie</a>
  </body>
</html>

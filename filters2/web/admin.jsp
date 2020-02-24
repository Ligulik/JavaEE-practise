<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-22
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Administratora</title>
</head>
<body>
    <h1>Witaj w panelu administratora!</h1>
        <h2>Twoje Ip to: <%=request.getRemoteAddr()%></h2>
<a href="LogoutServlet">Wyloguj sie</a>
</body>
</html>

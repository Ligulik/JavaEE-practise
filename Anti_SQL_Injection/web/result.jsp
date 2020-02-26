<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-26
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Okno przywitania</title>
</head>


<body>
    <h1>Witaj + <%=session.getAttribute("username")%></h1>
    <br>
    <h2>Twój dostęp: <%=session.getAttribute("priviliges")%></h2>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-22
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zaloguj sie</title>
</head>
<body>
    <h1>Podaj swoje dane</h1>
        <form action="LoginServlet" method="post">
            Username:<input type="text" name="username">
            <br>
            Password:<input type="text" name="password">
            <br>
            <input type="submit" value="Zaloguj">
        </form>

</body>
</html>

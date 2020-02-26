<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-26
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Strona logowania</title>
  </head>


  <body>
    <form action="login" method="post">
      <input type="text" placeholder="Login" name="username">
      <br>
      <input type="text" placeholder="Hasło" name="password">
      <br>
      <input type="submit" value="Zaloguj">
    </form>
  </body>
</html>

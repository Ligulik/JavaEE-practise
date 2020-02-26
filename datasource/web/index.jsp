<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-26
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Strona główna</title>
  </head>


  <body>
    <h1>Przeglądarka miast</h1>
      <form action="ControlerServlet" method="post">
        <input type="text" placeholder="Dzielnica" name="district">
        <br>
        <input type="text" placeholder="Miasto" name="country">
        <br>
        <input type="text" placeholder="Populacja" name="population">
        <br>
        Dodaj<input type="radio" name="option" value="add">Usun<input type="radio" name="option" value="delete">
        <br>
        <input type="submit" value="Wyślij">
      </form>
  </body>
</html>

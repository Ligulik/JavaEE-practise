<%--
  Created by IntelliJ IDEA.
  User: komp
  Date: 2020-02-24
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Informacje o ciasteczkach</title>
</head>



<body>

    <%
        if(request.getCookies()!=null)
            for(Cookie ciastko:request.getCookies()){
    %>
        <%=ciastko.getName() + " : " + ciastko.getValue()%>
        <br>

    <%
            }

   %>
<br>
<br>

<a href="CookieServlet?cookie=check">Refresh site</a>
<br>
<a href="index.jsp" target="_blank">Homepage</a>
</body>


</html>

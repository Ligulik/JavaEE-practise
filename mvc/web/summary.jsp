<%@ page import="pl.javastart.model.CartItem"%>
<%@ page import="java.util.List"%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Podsumowanie zakupu</title>
</head>
<body>
<h1>Podsumowanie zakupów</h1>
<h2>Lista zakupów:</h2>
<ol>
    <%
        List<CartItem> cart = (List<CartItem>)request.getAttribute("cart");
        for(CartItem item: cart) {
    %>
    <li>
        <%=
        String.format("%s, Cena oryginalna: %.2f, Cena po rabacie: %.2f",
                item.getProduct(), item.getOriginalPrice(), item.getDiscountPrice())
        %>
    </li>
    <%
        }
    %>
</ol>
<h2>Suma przed rabatem: <%= request.getAttribute("originalSum") %></h2>
<h2>Suma po rabacie: <%= request.getAttribute("discountSum") %></h2>
</body>
</html>
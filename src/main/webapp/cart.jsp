<%--
  Created by IntelliJ IDEA.
  User: jamesstark
  Date: 2025-10-04
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="java.util.*, bo.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head><title>Your Cart</title></head>
<body>
<h2>Your Shopping Cart</h2>

<% List<Product> cart = (List<Product>) session.getAttribute("cart"); %>
<% if (cart != null && !cart.isEmpty()) { %>
<table border="1" cellpadding="6">
    <tr><th>Product</th><th>Price</th></tr>
    <% double total = 0;
        for(Product p : cart){ total += p.getPrice(); %>
    <tr><td><%= p.getName() %></td><td><%= p.getPrice() %> kr</td></tr>
    <% } %>
</table>
<p><strong>Total:</strong> <%= total %> kr</p>
<form action="checkout" method="post">
    <button type="submit">Checkout</button>
</form>
<% } else { %>
<p>Your cart is empty.</p>
<% } %>

<p><a href="products">Continue Shopping</a></p>
</body>
</html>

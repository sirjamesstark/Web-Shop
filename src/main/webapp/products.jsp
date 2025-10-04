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
<head><title>Products</title></head>
<body>
<h2>Available Products</h2>

<% List<Product> products = (List<Product>) request.getAttribute("products"); %>
<% if (products != null) { %>
<table border="1" cellpadding="6">
    <tr><th>Name</th><th>Price</th><th>Stock</th><th></th></tr>
    <% for(Product p : products){ %>
    <tr>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %> kr</td>
        <td><%= p.getStock() %></td>
        <td>
            <% if (p.getStock() > 0) { %>
            <form action="cart" method="post">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <button type="submit">Add to cart</button>
            </form>
            <% } else { %>
            <button disabled>Out of stock</button>
            <% } %>
        </td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>No products found.</p>
<% } %>

<p><a href="cart.jsp">View Cart</a> | <a href="logout">Logout</a></p>
</body>
</html>

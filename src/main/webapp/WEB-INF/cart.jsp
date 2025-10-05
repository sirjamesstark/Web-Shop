<%@ page import="java.util.*, bo.Product" %>
<%@ page import="bo.UserHandler" %>
<%@ page import="ui.OrderInfo" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>Your Cart</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
        <div class="nav">
            <form method="post">
                <input type="hidden" name="action" value="home" />
                <input type="submit" value="Home">
            </form>
            <form method="post">
                <input type="hidden" name="action" value="login" />
                <input type="submit" value="Logout">
            </form>
        </div>

        <h2>Your Shopping Cart</h2>

        <% Collection<OrderInfo> cart = UserHandler.getOrders(); %>
        <% if (cart != null && !cart.isEmpty()) { %>
        <table border="1" cellpadding="6">
            <tr><th>Product</th><th>Price</th><th>Quantity</th></tr>
            <% double total = 0;
                for(OrderInfo order : cart){ total += (order.getProduct().getPrice() * order.getQuantity()); %>
            <tr>
                <td><%= order.getProduct().getName() %></td>
                <td><%= order.getProduct().getPrice() %> kr</td>
                <td><%= order.getQuantity() %></td>
            </tr>
            <% } %>
        </table>
        <p><strong>Total:</strong> <%= total %> kr</p>
        <form action="checkout" method="post">
            <button type="submit">Checkout</button>
        </form>
        <% } else { %>
        <p>Your cart is empty.</p>
        <% } %>
    </body>
</html>

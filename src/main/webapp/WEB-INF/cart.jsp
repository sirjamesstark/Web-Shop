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
        <header>
            <div class="nav">
                <form method="post">
                    <input type="hidden" name="action" value="home" />
                    <button type="submit">Home</button>
                </form>
                <form method="post">
                    <input type="hidden" name="action" value="login" />
                    <button type="submit">Logout</button>
                </form>
            </div>
        </header>
        <div class="container">
            <h2>Your Shopping Cart</h2>
            <% double total = 0; %>
            <div class="product-grid">
                <% Collection<OrderInfo> cart = UserHandler.getOrders(); %>
                <% if (cart != null && !cart.isEmpty()) { %>
                <% for(OrderInfo order : cart){ total += (order.getProduct().getPrice() * order.getQuantity()); %>
                <div class="product-card">
                    <div class="product-name"><%= order.getProduct().getName()%></div>
                    <div class="product-price"><%= order.getProduct().getPrice()%>kr</div>
                    <div class="product-price">Quantity: <%= order.getQuantity()%></div>
                </div>
                <% } %>
                <% } else { %>
                <p>Your cart is empty.</p>
                <% } %>
            </div>
            <p><strong>Total:</strong> <%= total %> kr</p>
        </div>
        <footer>
            <p class="copyright">CoreByte © 2025</p>
        </footer>
    </body>
</html>

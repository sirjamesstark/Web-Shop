<%@ page import="java.util.*, bo.ProductHandler, ui.ProductInfo" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
        <div class="nav">
            <form method="post">
                <input type="hidden" name="action" value="cart" />
                <input type="submit" value="Cart">
            </form>
            <form method="post">
                <input type="hidden" name="action" value="login" />
                <input type="submit" value="Logout">
            </form>
        </div>
        <h2> Hi <%= session.getAttribute("user") %> </h2>
        <h2>Available Products</h2>

        <% Collection<ProductInfo> products = ProductHandler.getProducts(); %>
        <% if (products != null) { %>
        <table border="1" cellpadding="6">
            <tr><th>Name</th><th>Price</th><th></th></tr>
            <% for(ProductInfo p : products){ %>
            <tr>
                <td><%= p.getName() %></td>
                <td><%= p.getPrice() %> kr</td>
                <td>
                    <form method="post">
                        <input type="hidden" name="id" value="<%= p.getProductID() %>" />
                        <input type="hidden" name="action" value="addToCart" />
                        <button type="submit" value="addToCart">Add to cart</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
        <% } else { %>
        <p>No products found.</p>
        <% } %>
    </body>
</html>
<%@ page import="java.util.*, bo.ProductHandler, ui.ProductInfo" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Products</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
        <header>
            <div class="nav">
                <form method="post">
                    <input type="hidden" name="action" value="cart" />
                    <button type="submit">Cart</button>
                </form>
                <form method="post">
                    <input type="hidden" name="action" value="login" />
                    <button type="submit">Logout</button>
                </form>
            </div>
        </header>
        <div class="container">
            <h2> Hi <%= session.getAttribute("user") %> </h2>
            <h2>Available Products</h2>
            <div class="product-grid">
                <% Collection<ProductInfo> products = ProductHandler.getProducts(); %>
                <% if (products != null) { %>
                    <% for(ProductInfo p : products){ %>
                    <div class="product-card">
                        <div class="product-name"><%= p.getName()%></div>
                        <div class="product-price"><%= p.getPrice()%>kr</div>
                        <form method="post">
                            <input type="hidden" name="id" value="<%= p.getProductID() %>" />
                            <input type="hidden" name="action" value="addToCart" />
                            <button type="submit" value="addToCart" class="add-button">Add to cart</button>
                        </form>
                    </div>

                    <% } %>
                <% } else { %>
                <p>No products found.</p>
                <% } %>
            </div>
        </div>
        <footer>
            <p class="copyright">CoreByte © 2025</p>
        </footer>
    </body>
</html>
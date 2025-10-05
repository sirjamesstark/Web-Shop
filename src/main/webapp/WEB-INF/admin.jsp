<%@ page import="java.util.*, bo.User, bo.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>Admin Panel</title></head>
    <body>
        <h2>Admin Dashboard</h2>

        <h3>Users</h3>
        <% List<User> users = (List<User>) request.getAttribute("users"); %>
        <% if (users != null) { %>
        <table border="1" cellpadding="6">
          <tr><th>Username</th><th>Role</th><th>Action</th></tr>
          <% for(User u : users){ %>
          <tr>
            <td><%= u.getUsername() %></td>
            <td>
              <form action="admin" method="post">
                <input type="hidden" name="username" value="<%= u.getUsername() %>">
                <select name="role">
                  <option value="customer">customer</option>
                  <option value="warehouse">warehouse</option>
                  <option value="admin">admin</option>
                </select>
                <button type="submit">Change</button>
              </form>
            </td>
          </tr>
          <% } %>
        </table>
        <% } %>

        <h3>Products</h3>
        <p><a href="addProduct.jsp">Add new product</a></p>
        <table border="1" cellpadding="6">
          <tr><th>Name</th><th>Price</th><th>Stock</th></tr>
          <% List<Product> plist = (List<Product>) request.getAttribute("products");
            if (plist != null) {
              for(Product p : plist){ %>
          <tr><td><%= p.getName() %></td><td><%= p.getPrice() %></td></tr>
          <% }
          } %>
        </table>
    </body>
</html>

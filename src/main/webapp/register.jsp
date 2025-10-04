<%--
  Created by IntelliJ IDEA.
  User: jamesstark
  Date: 2025-10-04
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>Register</title></head>
    <body>
        <h2>Register</h2>
        <form action="register" method="post">
          <label>Username:</label><br>
          <input type="text" name="username" required><br><br>
          <label>Password:</label><br>
          <input type="password" name="password" required><br><br>
          <label>Role:</label><br>
          <select name="role">
            <option value="customer">Customer</option>
          </select><br><br>
          <button type="submit">Create Account</button>
        </form>
        <p><a href="login.jsp">Back to login</a></p>
    </body>
</html>
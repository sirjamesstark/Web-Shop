<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head><title>Add Product</title></head>
    <body>
        <h2>Add New Product</h2>
        <form action="addProduct" method="post">
            <label>Name:</label><br>
            <input type="text" name="name" required><br><br>
            <label>Price:</label><br>
            <input type="number" name="price" required><br><br>
            <label>Stock:</label><br>
            <input type="number" name="stock" required><br><br>
            <button type="submit">Save</button>
        </form>
        <p><a href="admin.jsp">Back</a></p>
    </body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Web Shop</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1><%= "Please Sign In" %></h1>
        <br/>
        <div class="login">
            <form method="post">
                Username <input type="text" name="username" placeholder="enter username" required="required"><br>
                Password <input type="password" name="password" placeholder="**********" required="required"><br>
                <input type="submit" value="SUBMIT">
            </form>
        </div>
    </body>
</html>
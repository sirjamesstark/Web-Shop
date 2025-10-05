<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Web Shop</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    </head>
    <body>
        <header>
        </header>
        <div class="container">
            <div class="login">
                <h1> Please Sign In </h1>
                <form method="post">
                    <input type="hidden" name="action" value="login" />
                    <input type="text" name="username" placeholder="enter username" required="required">
                    <input type="password" name="password" placeholder="**********" required="required">
                    <button type="submit">Sign in</button>
                </form>
            </div>
        </div>
        <footer>
            <p class="copyright">CoreByte © 2025</p>
        </footer>
    </body>
</html>
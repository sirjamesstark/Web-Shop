package ui;

import java.io.*;

import bo.UserHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;


@WebServlet(name = "webShop", value = "/")
public class WebShopServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".jpg")) {
            req.getServletContext().getNamedDispatcher("default").forward(req, resp);
            return;
        }
        if(req.getSession().getAttribute("user") == null)
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            switch(req.getParameter("action")) {
                case "login":
                    login(req, resp);
                    break;
                case "home":
                    req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
                    break;
                case "cart":
                    req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
                    break;
                case "addToCart":
                    System.out.println("Got cart request");
                    if(req.getSession().getAttribute("userID") != null && req.getSession().getAttribute("user") != null) {
                        System.out.println("Attempting to add to cart values " + (int) req.getSession().getAttribute("userID") + " and " + Integer.parseInt(req.getParameter("id")));
                        if (UserHandler.addToCart((int) req.getSession().getAttribute("userID"), Integer.parseInt(req.getParameter("id"))))
                            System.out.println("Successfully added to cart");
                        else
                            System.out.println("Failed to add to cart");
                    }
                    else
                        login(req, resp);
                    resp.sendRedirect(req.getContextPath() + "/");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserInfo user = UserHandler.getUser(username, req.getParameter("password"));
        if (user != null) {
            req.getSession().setAttribute("user", username);
            req.getSession().setAttribute("userID", user.getUserID());
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        } else {
            req.getSession().removeAttribute("user");
            req.getSession().removeAttribute("userID");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }

    public void destroy() {
    }
}
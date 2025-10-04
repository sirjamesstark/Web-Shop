package ui;

import java.io.*;

import bo.UserHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "webShop", value = "/web-shop")
public class WebShopServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        System.out.println("Hello World!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        try {
            UserInfo user = UserHandler.getUser(username, password);
            if(user != null){
                rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            } else {
                session.setAttribute("username", username);
                rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void destroy() {
    }
}
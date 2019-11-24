package com.tactfactory.javaeelogin.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tactfactory.javaeelogin.controllers.UserController;
import com.tactfactory.javaeelogin.entities.User;

/**
 * Servlet implementation class HomeUserServlet
 */
@WebServlet("/home")
public class HomeUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<Integer, User> users = new HashMap<>();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        request.setAttribute("UserList", users);
        ServletContext app = this.getServletContext();
        users = (Map<Integer, User>) app.getAttribute("UserList");

        UserController userController = new UserController(app);

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("home");
        rd.forward(request, response);
    }
}

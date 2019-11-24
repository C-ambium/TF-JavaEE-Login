package com.tactfactory.javaeelogin.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
 * Servlet implementation class UserCardEdit
 */
@WebServlet("/edit/*")
public class UserCardEdit extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<Integer, User> users = new HashMap<>();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ServletContext app = this.getServletContext();
        UserController userController = new UserController(app);
        users = (Map<Integer, User>) app.getAttribute("UserList");

        Integer selectId = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("SelectUser", users.get(selectId));

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("edit");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // INIT
        ServletContext app = this.getServletContext();
        users = (Map<Integer, User>) app.getAttribute("UserList");

        // Get parameters from UserCardEdit.jsp form
        String selectId = request.getParameter("id");

        String email = request.getParameter("login");

        String username = request.getParameter("username");

        String firstname = request.getParameter("firstname");

        String lastname = request.getParameter("lastname");

        String address = request.getParameter("address");

        String phone = request.getParameter("phone");

        String avatar =  request.getParameter("avatar");

        String valid =  request.getParameter("valid");;

        // Update user
        if (valid.equals("Valider")) {
            User updateUser = new User(Integer.parseInt(selectId), username, firstname, lastname, address, phone, email, avatar);
            users.replace(Integer.parseInt(selectId), updateUser);
//            app.setAttribute("UserList", users);
            String url = String.format("http://localhost:8080/JavaEE-Login/show/user/?id=%d", updateUser.getId());
            response.sendRedirect(url);
        }
    }
}

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

import com.tactfactory.javaeelogin.entities.User;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/register")
public class UserRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<Integer, User> users = new HashMap<>();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("register");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        ServletContext app = this.getServletContext();
        users = (Map<Integer, User>) app.getAttribute("UserList");

        Integer id = users.size() + 1;

        String email = request.getParameter("login");

        String username = request.getParameter("username");

        String firstname = request.getParameter("firstname");

        String lastname = request.getParameter("lastname");

        String address = request.getParameter("address");

        String phone = request.getParameter("phone");

        String avatar =  request.getParameter("avatar");;

        if (username != null && username.trim().length() > 0) {
            User newUser = new User(id, username, firstname, lastname, address, phone, email, avatar);
            users.put(newUser.getId(), newUser);
            String url = String.format("show/user/?id=%d", newUser.getId());
            response.sendRedirect(url);
        } else {
            rd = this.getServletContext().getNamedDispatcher("register");
            request.setAttribute("RegisterError", "* Veuillez remplir les champs obligatoires !");
            rd.forward(request, response);
        }
    }

}

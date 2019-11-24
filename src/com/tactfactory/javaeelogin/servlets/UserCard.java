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
 * Servlet implementation class UserCard
 */
@WebServlet("/show/*")
public class UserCard extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<Integer, User> users = new HashMap<>();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // init Context & Controller
        ServletContext app = this.getServletContext();
        UserController userController = new UserController(app);
        users = (Map<Integer, User>) app.getAttribute("UserList");

        Integer selectId;

        selectId = Integer.parseInt(request.getParameter("id"));

        if (request.getParameter("id") != null && Integer.parseInt(request.getParameter("id")) <= users.size()) {
            request.setAttribute("SelectUser", users.get(selectId));
        }

/*      // Another method to check submit post on form button
 *
 *      String eventDel = request.getParameter("delete");
 *      String eventShow = request.getParameter("show");
 *      String eventEdit = request.getParameter("edit");
 *
 *      else if (eventEdit != null && eventEdit.equals("Modifier")) {
 *          selectId = Integer.parseInt(request.getParameter("id"));
 *      }
 *      else if (eventDel != null && eventDel.equals("Supprimer")) {
 *          selectId = Integer.parseInt(request.getParameter("id"));
 *
 *      // Extract ID from path
 *      String path = request.getRequestURI().toString();
 *      selectId = Integer.parseInt(path.substring(path.lastIndexOf("/") + 1)); // extract id from path

 *      }
 */

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("usercard");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selectId = request.getParameter("id");
        String eventDel = request.getParameter("delete");
        String eventEdit = request.getParameter("edit");

        ServletContext app = this.getServletContext();
        UserController userController = new UserController(app);

        if (eventDel != null && eventDel.equals("Supprimer")) {
            userController.delete(Integer.parseInt(selectId));
            response.sendRedirect("http://localhost:8080/JavaEE-Login/home");
        } else if (eventEdit != null && eventEdit.equals("Modifier")) { // Unreachable ressources
            response.sendRedirect("http://localhost:8080/JavaEE-Login/edit/user/?id=" + selectId);
        } else {
            response.sendRedirect("http://localhost:8080/JavaEE-Login/show/user/?id=" + selectId);
        }

    }
}


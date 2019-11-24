/**
 *
 */
package com.tactfactory.javaeelogin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** (Servlet implementation class Logout)
 * @see HttpServlet#HttpServlet()
 * @author Colin Cerveaux @C-ambium
 * Link to logout.jsp
 */
@WebServlet("/logout")
public class Logout  extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("logout");
        rd.forward(request, response);

        // Optional Function to wait & set header before redirect
        // response.setHeader("Refresh", "10; URL=localhost:8080/JavaEE-Login/login");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect("login");

    }

}

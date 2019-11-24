package com.tactfactory.javaeelogin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** (Servlet implementation class UserLogin)
 * @see HttpServlet#HttpServlet()
 * @author Colin Cerveaux @C-ambium
 * Link to login.jsp
 */

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /** (doGet Servlet)
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        rd = this.getServletContext().getNamedDispatcher("UserLogin");
        rd.forward(request, response);
    }

    /* (doPost)
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest, HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        RequestDispatcher rd;

        String login = request.getParameter("login");

        String password = request.getParameter("password");

        displaySession(session);

        if (checkLogin(login, password)) {
            // If checkLogin true - set attributes login and password to session and redirect to home page.
            session.setAttribute("username", login);
            session.setAttribute("password", password);
            response.sendRedirect("home");
        } else {
            // Else display an error and stay on the same login page.
            rd = this.getServletContext().getNamedDispatcher("UserLogin");
            request.setAttribute("LoginError", "*Veuillez saisir un pseudo et un mot de passe !");
            rd.forward(request, response);
        }
    }

    /** Function to display HttpSession informations into console.
     * @param session from HttpSession.
     */
    public void displaySession(HttpSession session) {

        StringBuilder sb = new StringBuilder();

        sb.append("ID : ")
            .append(session.getId())
            .append("Max Age : ")
            .append(session.getMaxInactiveInterval())
            .append("Key Session : ")
            .append(session.getAttribute("key_session"));

        System.out.println(sb.toString());
    }

    /** Function to check login : username and password before connection.
     * @param login - username/pseudo : not null & not empty
     * @param password - not null & not empty
     * @return boolean true if the user can access to the home page.
     */
    public boolean checkLogin(String login, String password) {

        boolean accept;

        if (login != null && !"".equals(login.trim()) && password != null && !"".equals(password.trim())) {
            accept = true;

        } else {
            accept = false;
        }
        return accept;
    }
}

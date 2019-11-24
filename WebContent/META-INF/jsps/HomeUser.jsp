<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.tactfactory.javaeelogin.entities.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil - Liste des utilisateurs</title>
<style>
<%@include file="../../../res/css/style.css"%>
</style>
<%@include file="../../res/head2.htm"%>
  <body>

    <header>
      <%@include file="../../res/header-home.htm"%>
      <%
        final String URI = "/JavaEE-Login/show/user";
        Map<Integer, User> users = new HashMap<>();
        ServletContext app = this.getServletContext();

        try {
          users = (Map<Integer, User>) app.getAttribute("UserList");
        } catch (Exception e) {
          out.append(e.getMessage());
        }

        if (session.getAttribute("username") != null) {
        %>
        <br><br>
        <h3>
        Bonjour
        <%=
        session.getAttribute("username")
        %> :)
        <%
          }
        %>
      </h3>
    </header>
    <div class="usertable">
      <table id="users" class="ui celled table">
        <thead>
          <tr>
            <th colspan="12">Liste des Utilisateurs</th>
          </tr>
          <tr>
            <th>Sel</th>
            <th>ID</th>
            <th>Avatar</th>
            <th>Pseudo</th>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Adresse</th>
            <th>Téléphone</th>
            <th>E-m@il</th>
            <th>Profil</th>
            <th>Modifier</th>
            <th>Supprimer</th>
          </tr>
        </thead>

        <tbody>
          <% for (HashMap.Entry<Integer, User> u : users.entrySet()) { %>
          <tr>
            <td><input type="checkbox" id="select" name="select"></td>
            <td><%= u.getValue().getId() %></td>
            <td><img class="avatar" src="<%=request.getContextPath()%>/res/img/cats/<%= u.getValue().getAvatar() %>"
            width=100px alt="Avatar<%= u.getValue().getId() %>" title="Photo Profil"/></td>
            <td><%= u.getValue().getUsername() %></td>
            <td><%= u.getValue().getFirstname() %></td>
            <td><%= u.getValue().getLastname() %></td>
            <td><%= u.getValue().getAddress() %></td>
            <td><%= u.getValue().getPhone() %></td>
            <td><%= u.getValue().getEmail() %></td>
            <td>
              <form class="showbutton"  method="post" action="<%= URI %>/?id=<%= u.getValue().getId() %>">
                  <input type="submit" value="Voir" name="show" >
              </form>
            </td>
            <td>
              <form class="editbutton" method="post" action="<%= URI %>/?id=<%= u.getValue().getId() %>">
                  <input type="submit" name="edit" value="Modifier">
              </form>
            </td>
            <td>
              <form action="<%= URI %>/delete/?id=<%= u.getValue().getId() %>" method="post"
                   onClick="return ConfirmDelete(this)">
                <input type="submit" value="Supprimer" name="delete">
              </form>
            </td>
            <% }; %>
          </tr>
        </tbody>
      </table>
    </div>

    <footer>
      <p>Copyright ©2019 OVG - Tous droits réservés.</p>
    </footer>

    </body>
</html>

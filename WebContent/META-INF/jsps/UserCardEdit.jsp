<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tactfactory.javaeelogin.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

  <head>
    <meta charset="UTF-8">
    <title>Modification Utilisateur</title>
    <%@include file="../../res/head2.htm"%>
    <style><%@include file="../../res/css/style-view.css"%></style>
  </head>

  <body>
    <header>
      <%@include file="../../res/header-view.htm"%>
      <%
        final String URI = "/JavaEE-Login";
        User u = (User) request.getAttribute("SelectUser");
        %>
    </header>

    <br>
    <br>

    <div class="edit">
      <table id="users" class="usercard">
        <thead>
          <tr>
            <th colspan="3">Edition Fiche Utilisateur</th>
          </tr>
          <tr>
            <th>Dénomination</th>
            <th>Anciennes Valeurs</th>
            <th>Nouvelles Valeurs</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>ID</td>
            <td><%= u.getId() %></td>
            <td><%= u.getId() %></td>
          </tr>
           <tr>
            <td>Avatar</td>
            <% if (u.getId() < 50) { %>
              <td> <img class="avatar" src="../../res/img/cats/<%= u.getAvatar() %>" alt="Avatar" width="200px"></td>
            <% } else { %>
            <td> <img class="avatar" src="<%= u.getAvatar() %>" alt="Avatar" width="200px"></td>
           <% } %>
            <td><input type="url" name="avatar" placeholder="Avatar"></td>
          </tr>
          <tr>
            <td>Pseudo</td>
            <td><%= u.getUsername() %></td>
            <td>
              <form method="post">
                <input type="text" name="username" placeholder="Pseudo" value="<%= u.getUsername() %>">
              </form>
            </td>
          </tr>
          <tr>
            <td>Mot de passe</td>
            <td>••••••••</td> <%-- <%= u.getPassword() %> --%>
            <td>
              <form method="post">
                <input type="password" name="password" placeholder="Mot de passe">
              </form>
              </td>
          </tr>
          <tr>
            <td>Prénom</td>
            <td><%= u.getFirstname() %></td>
            <td>
              <form method="post">
                <input type="text" name="firstname" placeholder="Prénom" value="<%= u.getFirstname() %>">
              </form>
            </td>
          </tr>
          <tr>
            <td>Nom</td>
            <td><%= u.getLastname() %></td>
            <td>
              <form method="post">
                <input type="text" name="lastname" placeholder="Nom" >
              </form>
            </td>
          </tr>
          <tr>
            <td>Adresse</td>
            <td><%= u.getAddress() %></td>
            <td>
              <form method="post">
                <input type="text" name="address" placeholder="Adresse"  value="<%= u.getAddress() %>">
              </form>
            </td>
          </tr>
          <tr>
            <td>Téléphone</td>
            <td><%= u.getPhone() %></td>
            <td>
              <form method="post">
                <input type="text" name="phone" placeholder="Téléphone"  value="<%= u.getPhone() %>">
              </form>
            </td>
          </tr>
          <tr>
            <td>E-m@il</td>
            <td><%= u.getEmail() %></td>
            <td>
              <form method="post">
                <input type="email" name="email" placeholder="Email"  value="<%= u.getEmail() %>">
              </form>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="bottombutton">
      <br>
      <form class="freebutton" method="post">
        <input type="submit" name="valid" value="Valider">
      </form>
      <form class="freebutton" action="<%= URI %>/home">
        <input type="submit" name="back" value="Retour">
      </form>
    </div>


      <footer>
        <p>Copyright ©2019 OVG - Tous droits réservés.</p>
      </footer>
  </body>
</html>

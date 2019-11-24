<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <title>Fiche Utilisateur</title>
  <%@include file="../../res/head2.htm"%>
  <style><%@include file="../../res/css/style-view.css"%></style>
<%--   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}res/css/style.css" /> --%>
<%--   <link href="<c:url value='/res/css/style-view.css'/>" rel="stylesheet"> --%>
</head>

<body>
  <header>
    <%@include file="../../res/header-view.htm"%>
    <%
      final String URI = "/JavaEE-Login";
      ServletContext app = this.getServletContext();
      User u = (User) request.getAttribute("SelectUser");
      %>
  </header>

  <br>
  <br>

  <div class="view">
    <table id="users" class="usercard">
      <thead>
        <tr>
          <th colspan="2">Fiche Utilisateur</th>
        </tr>
        <tr>
          <th>Dénomination</th>
          <th>Valeur</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>ID</td>
          <td><%= u.getId() %></td>
        </tr>
         <tr>
          <td>Avatar</td>
          <% if (u.getId() < 50) { %>
            <td> <img class="avatar" src="../../res/img/cats/<%= u.getAvatar() %>" alt="Avatar" width="200px"></td>
          <% } else { %>
          <td> <img class="avatar" src="<%= u.getAvatar() %>" alt="Avatar" width="200px"></td>
         <% } %>
        </tr>
        <tr>
          <td>Pseudo</td>
          <td><%= u.getUsername() %></td>
        </tr>
        <tr>
          <td>Prénom</td>
          <td><%= u.getFirstname() %></td>
        </tr>
        <tr>
          <td>Nom</td>
          <td><%= u.getLastname() %></td>
        </tr>
        <tr>
          <td>Adresse</td>
          <td><%= u.getAddress() %></td>
        </tr>
        <tr>
          <td>Téléphone</td>
          <td><%= u.getPhone() %></td>
        </tr>
        <tr>
          <td>E-m@il</td>
          <td><%= u.getEmail() %></td>
        </tr>
      </tbody>
    </table>
  </div>

  <div class="bottombutton">
    <br>
    <form class="freebutton" method="post" >
      <input type="submit" name="edit" value="Modifier">
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

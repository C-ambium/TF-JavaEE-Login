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
<title>Inscription Utilisateur</title>
<style>
<%@include file="../../../res/css/style.css"%>
</style>
<%@include file="../../res/head2.htm"%>
<body>

  <header>
    <%@include file="../../res/header-register.htm"%>
  </header>

  <div class="log">
    <br>
    <h2>
      Merci de remplir tous les champs<br>C'est presque fini :)
    </h2>
    <form class="loginput" method="post">
      <input type="email" name="email" placeholder="Email"> <br>
      <br> <input type="text" name="username" placeholder="Pseudo*"><br>
      <br> <input type="text" name="firstname" placeholder="Prénom"><br>
      <br> <input type="text" name="lastname" placeholder="Nom"><br>
      <br> <input type="text" name="address" placeholder="Adresse"><br>
      <br> <input type="text" name="phone" placeholder="Téléphone"><br>
      <br> <input type="password" name="password" placeholder="Mot de passe"><br>
      <br> <input type="url" name="avatar" placeholder="Avatar"><input type="file" name="file" placeholder="Upload"><br>
      <br> <input class="buttonlog" type="submit" value="Inscription">
      </form>
      <%
      if (request.getAttribute("RegisterError") != null) {
      %>
      <span class="error"><%=request.getAttribute("RegisterError")%></span><br>
      <%
      }
      %>
      <span class="agecheck"><sup>*</sup>En cliquant sur
        le bouton Inscription vous acceptez les conditions générales
        d'utilisation et attestez avoir plus de 13 ans.</span>
  </div>
</body>
</html>

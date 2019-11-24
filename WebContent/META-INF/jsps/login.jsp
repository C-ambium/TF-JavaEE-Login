<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page info="User Login JSP"%>
<!DOCTYPE html>

<html>

  <head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <%@ include file ="../../res/head2.htm" %>
    <style><%@include file ="/res/css/style.css"%></style>
  </head>

  <body>

    <header>
    <%@include file ="../../res/header-login.htm"%>
    </header>

    <div class="log">
      <br><h2>Veuillez vous connecter pour continuer</h2><br><br>

      <form class="loginput" method="post">
        <input type="text" name="login" placeholder="Pseudo*"> <br>
        <input type="password" name="password" placeholder="Mot de passe*"><br><br>
        <input class="buttonlog" type="submit" value="Connexion">
      </form>
      <%
        if (request.getAttribute("LoginError") != null) {
      %>
      <span class="error"><%=request.getAttribute("LoginError")%></span>
      <%
        }
      %>
    </div>

    <footer>
      <p>Copyright ©2019 OVG - Tous droits réservés.</p>
    </footer>
  </body>
</html>

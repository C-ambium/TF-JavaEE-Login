<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Deconnexion</title>
    <%@include file="../../res/head2.htm"%>
    <style><%@include file="../../res/css/style.css"%></style>
  </head>

  <body>
    <header>
      <%@include file="../../res/header-logout.htm"%>
    </header>
      <% if (session.getAttribute("username") != null) { %>
      <br><br><h3>Bye-bye <%= session.getAttribute("username") %> </h3><br>
      <%
        }
      %>
      <h3>Si vous êtes sûr, vous allez être redirigé ... </h3><br>
      <form class="freebutton"  method="post">
        <input type="submit" value="OK" name="ok" >
      </form>
      <img class="logout" alt="Deconnexion" src="https://www.shreejiwebdesign.com/wp-content/uploads/2017/08/logout.gif">
    <footer>
      <p>Copyright ©2019 OVG - Tous droits réservés.</p>
    </footer>
  </body>
</html>

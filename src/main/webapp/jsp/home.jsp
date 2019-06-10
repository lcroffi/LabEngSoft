<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Role"%>
<%@page import="model.User"%>

<!DOCTYPE html>
<html>
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  		<meta name="description" content="Sistema de cadastro de eleitor e votos">
  		<meta name="author" content="Leticia Croffi">		

        <link rel="stylesheet" type="text/css" href="${contexto}static/css/styles.css">
        <title>Sistema de Votação</title>
    </head>
    <body>
        <%
        	User u = (User)request.getAttribute("usuarioLogado");
        %>
        <%@include file= "menu.jsp" %>      
        <!-- Page Content -->
    <!-- Content section Start -->
    <div class="container">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
    </br>
    </br>
    </br>
    <h1 class="mt-4">Usuário logado como:</h1>
        <ul>
        <% for(Role p: u.getRoles() ){ %>
        <li><%= new String(p.getDescricao().toString().getBytes(),"UTF-8") %></li>
        <%} %>
        </ul>
    </br>
    </div>
    <div class="col-sm-3"></div>

  </div>
  </div>
  </div>
  <hr>
    <!-- Content section End --> 


  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy Sistema de Votação 2019</p>
    </div>
    <!-- /.container -->
  </footer>

</body>
</html>

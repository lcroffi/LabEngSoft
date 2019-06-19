<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
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
      
        <!-- Content section Start --> 
  <section id="content">
    </br></br>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<User> users = (List<User>)request.getAttribute("eleitores");
        for(User us : users) {
            if (!us.getAllowVote() && !us.getDone()) {%>

        <div class="container">
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
              <div class="page-register box">
                  <div class="card my-4">
                  <h5 class="card-header">Cadastro</h5>
                  
                  <table class="table table-bordered">
                  <div class="register-group">
                    <tr>
                      <td>Nome: </td>
                      <td><% out.print(us.getNome());  %></td>
                    </tr>
                  </div> 
                  <div class="register-group">
                      <tr>
                        <td>Data de Nascimento: </td>
                        <td><% out.print(sdf.format(us.getDob())); %></td>
                      </tr>
                  </div> 
                  <div class="register-group">
                      <tr>
                        <td>Município: </td>
                        <td><% out.print(us.getCity());  %></td>
                      </tr>
                  </div> 
                  <div class="register-group">
                      <tr>
                        <td>Estado: </td>
                        <td><% out.print(us.getState());  %></td>
                      </tr>
                  </div> 
                  <div class="register-group">
                      <tr>
                        <td>Número do Título: </td>
                        <td><% out.print(us.getNumeroTitulo());  %></td>
                      </tr>
                  </div> 
                  <div class="register-group">
                      <tr>
                        <td>Data de Emissão: </td>
                        <td><% out.print(sdf.format(us.getEmissaoTitulo())); %></td>
                      </tr>
                  </div> 
                  <div class="register-group">
                      <tr>
                        <td>Zona Eleitoral: </td>
                        <td><% out.print(us.getZona()); %></td>
                      </tr>
                  </div>
                  <div class="register-group">
                      <tr>
                        <td>Seção: </td>
                        <td><% out.print(us.getSecao()); %></td>
                      </tr>
                  </div>  
                </table>
              </div>
              </div>
              <form action="HabilitarVoto" method="get" class="authorization-form">
                  <div class="form-group">
                    <input type="hidden" name="id" value="<% out.print(u.getId()); %>">
                    <input type="hidden" name="habilitar" value="<% out.print(us.getId()); %>">
                    <button type="submit" class="btn btn-primary">Habilitar Votação</button>
                  </div>
                </form>
              </div>
              <div class="col-sm-4"></div>
              <%}
             } %>

              
            </div>
            <hr>
      </section>
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
  
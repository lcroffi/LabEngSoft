<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.Candidato"%>
<%@page import="java.util.List"%>
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
  <% if (u.getAllowVote() && !u.getDone()) {

        Candidato prefeito = (Candidato)request.getAttribute("prefeito");
        Candidato vice = (Candidato)request.getAttribute("vice");
        if (prefeito == null && vice == null) {
  %>
    <div class="container">
      <div class="row">
          <div class="col-sm-5 col-md-6">
          <div class="page-votacao box">
              <div class="card my-4">
              <h4 class="card-header">Digite o número do seu candidato para prefeito:</h4>
              <div class="card-body">
            <form class="baseForm" action="Votar" method="get">
              <div class="form-group">                
                <div class="input-icon">
                    <input type="hidden" name="id" value="<% out.print(u.getId()); %>">
                  <input type="number" class="scroll" id="sender-number" class="form-control" name="numero" placeholder="12 ou 17" required>
                </div>
              </div> 
                </br>
                <button type="submit" class="btn btn-primary">Selecionar</button>
            </form>
            </div>
              </div>               
            </div>
          </div>
        </div>

  <hr>
  </section>
  <%    }
        else {%>
  <div class="container">
    <div class="row">
        <div class="col-sm-5 col-md-6">
        <div class="page-votacao box">
            <div class="card my-4">
            <h4 class="card-header"><%=new String(prefeito.getOficio().toString().getBytes(),"UTF-8") %></h4>
            <div class="card-body">
          <form class="baseForm" action="Home" method="get">
            <div class="form-group">                
              <div class="input-icon">
                  <input type="hidden" name="id" value="<% out.print(u.getId()); %>">
                  <input type="hidden" name="confirm" value="<% out.print(prefeito.getNumeroUrna()); %>">
                  <h4>Número de Urna: <% out.print(prefeito.getNumeroUrna()); %></h4>
              </div>
            </div> 
            <div class="form-group">
              <div class="mayor">
                  </br>
                  <img src="${contexto}static/imgs/<% out.print(prefeito.getFoto()); %>">
              </div>
              
            </div>
            <div class="form-group">
              <div class="input-icon">
                <h4 class="mayor-name"><%=new String(prefeito.getNomeCandidato().toString().getBytes(),"UTF-8") %></h4>
                <h5 class="party"><%=new String(prefeito.getPartido().toString().getBytes(),"UTF-8") %></h5>
              </br>
              <button type="submit" class="btn btn-primary">Confirmar</button>
          </form>
          </div>
            </div>               
          </div>
        </div>
      </div>

  </div>
  <div class="col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0">
      <div class="card my-4">
      <h4 class="card-header"><%=new String(vice.getOficio().toString().getBytes(),"UTF-8") %></h4>
      <div class="card-body">
      <img src="${contexto}static/imgs/<% out.print(vice.getFoto()); %>" height="300">
      <h5 class="vice-name"><%=new String(vice.getNomeCandidato().toString().getBytes(),"UTF-8") %></h5>
      <h5 class="vice-party"><%=new String(vice.getPartido().toString().getBytes(),"UTF-8") %></h5>
      </div>
    </div>
    </div>
  </div>
</div>
<hr>
</section>
<% } %>
<% } else { %>
  <div class="container">
      <div class="row">
          <div class="col-sm-3"></div>
          <div class="col-sm-6">
 </br>
</br>
</br>
<h1 class="mt-4">Voto não habilitado.</h1>
</br>
</div>
<div class="col-sm-3"></div>


</div>
</div>
</div>
<hr>
<% } %>


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

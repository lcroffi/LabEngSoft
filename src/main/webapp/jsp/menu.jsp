<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="model.EnumRoles"%>
<%@page import="model.Role"%>
<%@page import="model.User"%>
<header>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Sistema de Votação</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
        <%
            	for(Role p: u.getRoles()){
                if( p.getDescricao().equals(EnumRoles.USUARIO_COMUM) ){
                  out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"${pageContext.request.contextPath}/Votar\">Votar</a></li>" +
                            "<li class=\"nav-item active\"> <a class=\"nav-link\" href=\"#\">Home</a><span class=\"sr-only\">(current)</span></li>" +
                            "<li class=\"nav-item\"><a class=\"nav-link\" href=\"${pageContext.request.contextPath}\">Sair</a></li>");
                }
                if( p.getDescricao().equals(EnumRoles.MESARIO) ){
                  out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"${pageContext.request.contextPath}/Habilitar\">Cadastro</a></li>");
                }
                if( p.getDescricao().equals(EnumRoles.CHEFE) ){
                  out.print("<li class=\"nav-item active\"> <a class=\"nav-link\" href=\"${pageContext.request.contextPath}/EmitirRelatorio\">Relatório</a></li>");
                }                                            
              }
        %>
        </ul>
      </div>
    </div>
  </nav>                                          
           
</header>

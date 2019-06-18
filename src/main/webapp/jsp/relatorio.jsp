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
    </br></br></br>
    <% List<Candidato> candidatos = (List<Candidato>)request.getAttribute("candidatos"); %>

        <div class="container">
            <div class="row">
                <div class="col-sm-5 col-md-6">
              <div class="page-report box">
                  <h5 class="report-header">Prefeito</h5>
                  
                  <table class="table table-bordered">
                  <div class="report-group">
                    <tr>
                      <td>Nome do Candidato </td>
                      <td>Número de Urna</td>
                      <td>Votos</td>
                    </tr>
                  </div> 
                  <% for(Candidato cs : candidatos) {
                    if (cs.getOficio().equals("Prefeito")) { %>
                  <div class="report-group">
                      <tr>
                        <td><%=new String(cs.getNomeCandidato().toString().getBytes(),"UTF-8") %></td>
                        <td><% out.print(cs.getNumeroUrna()); %></td>
                        <td><% out.print(cs.getVotos()); %></td>
                      </tr>
                  </div> 
                  <% }
                  } %>
                   
                </table>
              </div>
            </div>
          </div>
        </div>
      </br>
            <div class="container">
                <div class="row">
                    <div class="col-sm-5 col-md-6">
                <div class="page-report box">
                    <h5 class="report-header">Vereador</h5>
                    
                    <table class="table table-bordered">
                    <div class="report-group">
                      <tr>
                        <td>Nome do Candidato </td>
                        <td>Número de Urna</td>
                        <td>Votos</td>
                      </tr>
                    </div> 
                    <div class="report-group">
                        <tr>
                          <td>Eduardo Suplicy</td>
                          <td>1313</td>
                          <td>399</td>
                        </tr>
                    </div> 
                    <div class="report-group">
                        <tr>
                          <td>Juliana Cardoso</td>
                          <td>1122</td>
                          <td>229</td>
                        </tr>
                    </div>
                    <div class="report-group">
                        <tr>
                          <td>Amelia Naomi</td>
                          <td>1311</td>
                          <td>210</td>
                        </tr>
                    </div>
                    <div class="report-group">
                        <tr>
                          <td>Marie Curie</td>
                          <td>1923</td>
                          <td>113</td>
                        </tr>
                    </div>
                    <div class="report-group">
                        <tr>
                          <td>Margaret Heafield</td>
                          <td>2529</td>
                          <td>101</td>
                        </tr>
                    </div>
                    <div class="report-group">
                        <tr>
                          <td>Valentina Tereshkova</td>
                          <td>1234</td>
                          <td>099</td>
                        </tr>
                    </div> 
                    <div class="report-group">
                        <tr>
                          <td>Maud Stevens Wagner</td>
                          <td>5678</td>
                          <td>050</td>
                        </tr>
                    </div>  
                    <div class="report-group">
                        <tr>
                          <td>Maria Lacerda de Moura</td>
                          <td>1190</td>
                          <td>049</td>
                        </tr>
                    </div>  
                    <div class="report-group">
                        <tr>
                          <td>Theon Greyjoy</td>
                          <td>1700</td>
                          <td>001</td>
                        </tr>
                    </div>
                    <div class="report-group">
                        <tr>
                          <td>Damares Alves</td>
                          <td>1756</td>
                          <td>000</td>
                        </tr>
                    </div>
                  </table>
                  
                  <form action="index.html" method="get" class="return-form">
                    <div class="form-group">
                      <input type="hidden" class="form-control" value="back">
                    </div>        
                    <button type="submit" class="btn btn-primary">Retornar</button>
                  </form>
                </div>
              </div>
                </div>
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
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String contexto = request.getContextPath();
    if (!contexto.equals(""))
        contexto = contexto + "/";
%>
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
    <section id="content">    
      </br></br>
      <div class="container">
          <div class="row">
              <div class="col-sm-4"></div>
              <div class="col-sm-4">
              <div class="page-login-form box">
                <div class="card my-4">
                <h5 class="card-header">Login</h5>
                <div class="card-body">
            <form class="baseForm" action="Home" method="post">
                <div class="form-group">
                    <div class="input-icon">
                    <input type="text" id="sender-titulo" class="form-control" name="numeroTitulo" placeholder="Número do Título" required>
                    </div>
                  </div> 
                  <div class="form-group">
                    <div class="input-icon">
                    <input type="password" class="form-control" name="senha" placeholder="Senha" required>
                    </div>
                  </div>
                  </br>
                  <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
            <div class="col-sm-4"></div>
              </form>
          </div>
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

</body>

</html>
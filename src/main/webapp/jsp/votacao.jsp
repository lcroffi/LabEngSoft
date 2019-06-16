<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
              <a class="navbar-brand" href="index.html">Sistema de Votação</a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="./Votar">Votar</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="./Home">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="./">Sair</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>

  <!-- Content section Start --> 
  <section id="content">
  </br></br>
    <div class="container">
      <div class="row">
          <div class="col-sm-5 col-md-6">
          <div class="page-votacao box">
              <div class="card my-4">
              <h4 class="card-header">Prefeito</h4>
              <div class="card-body">
            <form action="index.html" method="get" class="votacao-form">
              <div class="form-group">                
                <div class="input-icon">
                  <input type="number" value="12" class="scroll" id="sender-number" class="form-control" name="numero" placeholder="Número" required>
                </div>
              </div> 
              <div class="form-group">
                <div class="mayor">
                    </br>
                    <img src="${contexto}static/imgs/prefeita.jpg">
                </div>
                
              </div>
              <div class="form-group">
                <div class="input-icon">
                  <h4 class="mayor-name">Tabata Claudia Amaral de Pontes</h4>
                  <h5 class="party">Partido Democrático Trabalhista</h5>
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
        <h4 class="card-header">Vice-Prefeito</h4>
        <div class="card-body">
        <img src="${contexto}static/imgs/vice.jpg" height="300">
        <h5 class="vice-name">Brienne de Tarth</h5>
        <h5 class="vice-party">Casa Stark</h5>
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
</footer>

</body>

</html>
